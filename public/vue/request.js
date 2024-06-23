var ctx = 'http://localhost:8088/study_system'; //项目基础路径
//axios请求基础路径配置
const instance = axios.create({
    baseURL: ctx,
    timeout: 10000
})


// 根据参数名获取参数值  获取网址中携带参数  例如 index.html?age=demo    getURLParameter("age")
function getURLParameter(name) {
    var result = location.search.match(new RegExp("[\?\&]" + name + "=([^\&]+)", "i"));
    if (result == null || result.length < 1) {
        return "";
    }
    return result[1];
}

// 控制台调试对象
function debugShow(data) {
    console.log(JSON.stringify(data));
}

// 不输入参数调用的就是当前时间
// 参数--需转换时间的时间戳
function getNowTime(time = new Date()) {
    let date = new Date(time);
    let YY = date.getFullYear();
    let MM = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
    let DD = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
    let hh = date.getHours() < 10 ? "0" + date.getHours() : date.getHours();
    let mm = date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes();
    let ss = date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds();
    // 这里修改返回时间的格式
    return YY + "-" + MM + "-" + DD + " " + hh + ":" + mm + ":" + ss;
}


function get(url, params) {
    return new Promise((resolve, reject) => {
        instance.get(url, {params: params})
            .then((res) => {
                resolve(res.data);
            })
            .catch((err) => {
                reject(err.data);
            });
    });
}


/**
 * post请求封装教程
 * https://blog.csdn.net/sebeefe/article/details/126080414
 * @param url  网址
 * @param data 参数
 * @returns
 */
function post(url, data) {
    // formdata对象
    let formdata = new FormData(); //springboot方便接收
    for (let key in data) {
        formdata.append(key, data[key])
        //console.log(key); // 获取key
        //console.log(obj[key]); // 获取value

    }
    //formdata.append('name', 'test')
    data = formdata;
    return new Promise((resolve, reject) => {
        instance.post(url, data, {
            headers: {'Content-Type': "multipart/form-data, charset=UTF-8"}
        })
            .then((res) => {
                resolve(res.data);
            })
            .catch((err) => {
                reject(err);
            });
    });
}


//加载轮播图
function getCarouselList() { //加载系统配置
    if (sessionStorage.getItem('carouselList') == null) {
        console.log("查询轮播图");
        var url = '/vue/selectAction';
        var data = {"sql": "select * from carousel "}
        post(url, data).then(response => {
            var carouselList = response.data;
            sessionStorage.setItem("carouselList", JSON.stringify(response.data));
        }).catch(err => {
            console.log(err);
        });

    }

    var carouselList = JSON.parse(sessionStorage.getItem('carouselList'));
    var ss = "";
    for (let i = 0; i < carouselList.length; i++) {
        ss = ss + "<div style='background-image: url(" + carouselList[i].picurl + ");background-size:100% 100%;'></div>";
    }

    if (document.getElementById("carouselListDiv")) {  //如果元素存在
        document.getElementById("carouselListDiv").innerHTML = ss;
    }

    loadNav();//加载导航条
}

//加载分类
function getMySorttypeList() { //加载数据

    var url = '/vue/selectAction';
    var data = {"sql": "select * from sortinfo "}
    post(url, data).then(response => {
        sessionStorage.setItem("sorttypelList", JSON.stringify(response.data));
    }).catch(err => {
        console.log(err);
    });
}

//退出登录
function loginOut() {
    //sessionStorage.clear();  //清除所有值
    sessionStorage.removeItem("loginUserinfo");
    // getCarouselList();  //取消加载轮播图 否则退出登陆会卡
    window.location.href = "index.html";
}

/**
 * 菜单 列表  isshow 1都显示  2登录前显示  3登录以后才显示
 */
var navList = [
    {"title": "MOOC中国大学慕课之天津分课", "url": "index.html", "isshow": 1, "add": ""},
    {
        "title": "首页",
        "url": "index.html",
        "isshow": 1,
        "add": "",
        // "add": '<i class="layui-icon layui-icon-home" style="font-weight: bold;"></i>'  //如果要添加图标请使用此代码
    },
    {"title": "公告", "url": "noticeinfo.html", "isshow": 1, "add": ""},
    {"title": "资料", "url": "filesinfoList.html", "isshow": 1, "add": ""},
    {"title": "视频推荐", "url": "index2.html", "isshow": 3, "add": ""},
    {"title": "后台管理", "url": "http://localhost:3000", "isshow": 2, "add": ""},
    //{"title": "后台管理", "url": "http://localhost:3000", "isshow": 2, "add": ""},
    {"title": "马上登陆", "url": "login.html", "isshow": 2, "add": ""},
    {"title": "点我注册", "url": "register.html", "isshow": 2, "add": ""},
    {"title": "任务列表", "url": "workinfoList.html", "isshow": 3, "add": ""},
    {"title": "我的作业", "url": "homeworkList.html", "isshow": 3, "add": ""},
    {"title": "我的成绩", "url": "scoreList.html", "isshow": 3, "add": ""},

    {"title": "发布课程", "url": "datainfoAdd.html", "isshow": 4, "add": ""},
    {"title": "发布任务", "url": "workinfoAdd.html", "isshow": 4, "add": ""},
    {"title": "查阅作业", "url": "homeworkList.html", "isshow": 4, "add": ""},
    {"title": "试卷管理", "url": "examinfo.html", "isshow": 4, "add": ""},
    {"title": "考试成绩", "url": "scoreList.html", "isshow": 4, "add": ""},
]

// vue版本后台 http://localhost:8088/myproject/admin/dist/index.html#/login
// vue版本后台 http://localhost:3000
// jsp版本后台 http://localhost:8088/myproject/admininfo/tologin


//加载导航条
function loadNav() { //加载数据
    var loginUserinfo = JSON.parse(sessionStorage.getItem('loginUserinfo'));
    var ss = "";
    //navList=JSON.parse(navList);
    for (var i = 0; i < navList.length; i++) {
        var obj = navList[i];
        var show = false;
        switch (obj.isshow) {
            case 1:  //1都显示
                show = true;
                break;
            case 2:   //2登录前显示
                if (loginUserinfo) {
                    show = false;
                } else {
                    show = true;
                }
                break;
            case 3:
                if (loginUserinfo && loginUserinfo.role == '学生') {
                    show = true;
                } else {
                    show = false;
                }
                break;
            case 4:
                if (loginUserinfo && loginUserinfo.role == '教师') {
                    show = true;
                } else {
                    show = false;
                }
                break;
            case 4:
                var day = "星期四";
                break;

        }
        if (show) {
            var li = '<li class="layui-nav-item"><a href="URL">AABB</a></li>'.replace("AA", obj
                .add).replace("URL", obj.url).replace("BB", obj.title);
            ss = ss + li;
        }
    }
    if (loginUserinfo) {
        ss = ss + '<li class="layui-nav-item">' +
            '                <a href=""><img src="' + loginUserinfo.picurl + '" class="layui-nav-img">' + loginUserinfo.name + " " + loginUserinfo.role + " " + '</a>' +
            '                <dl class="layui-nav-child">' +
            '                    <dd><a href="userinfoCenter.html">个人中心</a></dd>' +
            '                    <dd><a href="#" onclick="loginOut()">退出登录</a></dd>' +
            '                </dl>' +
            '            </li>';
    }
    if (document.getElementById("navDIV")) {  //如果元素存在
        document.getElementById("navDIV").innerHTML = ss;
    }

}





