import{z as e,A as l,B as a,p as o,a as t,L as r,r as d,o as i,c as n,f as s,w as u,h as p}from"./vendor.a8d67b6f.js";import{s as c}from"./request.7ef930c0.js";const m={name:"filesinfotable",methods:{handleAvatarError(l){e.error(l)},handleAvatarSuccess(l){l.isSuccess,e.error(l.error)},handleAvatarBeforeUpload:e=>!0,uploadSectionFile(l){let a=new FormData;a.append("file",l.file),a.append("dataid","11111"),c({url:"/uploadFile",method:"post",data:a}).then((l=>{if(200===l.status){e.success("上传成功");let a=l.data.url;console.log(a),this.form.picurl=a}else e.error(l.msg||"上传失败")}),(l=>{e.error("文件上传失败")}))}},setup(){const o=l({keyword:"",pageIndex:1,pageSize:10}),t=a([]),d=a(0),i=()=>{var e=o.keyword,l=o.pageIndex,a=o.pageSize,r=" select * from filesinfo  ";""!=e&&(l=1,r="select * from filesinfo where name like '%"+e+"%'  "),c({url:"/selectPageAction",method:"get",params:{sql:r,p:l,pageSize:a}}).then((e=>{t.value=e.data.records,d.value=e.data.total||10}))};i();let n=l({id:"",name:"",picurl:"",intro:""});const s=()=>{Object.keys(n).forEach((e=>n[e]="")),console.log("clear")},u=a(!1),p=a(!1);return{query:o,tableData:t,pageTotal:d,editVisible:u,form:n,handleSearch:()=>{o.pageIndex=1,i()},handlePageChange:e=>{o.pageIndex=e,i()},handleDelete:(l,a)=>{r.confirm("确定要删除吗？","提示",{type:"warning"}).then((()=>{var l=a.id;c({url:"/updateAction",method:"get",params:{sql:"delete  from filesinfo where  id='"+l+"' "}}).then((l=>{200===l.status?(e.success("删除成功"),i()):e.error(l.msg||"删除失败")}))})).catch((()=>{}))},handleEdit:(e,l)=>{Object.keys(n).forEach((e=>{n[e]=l[e]})),u.value=!0},saveEdit:()=>{u.value=!1;var l=n,a={sql:`  update filesinfo set name = '${l.name}',picurl = '${l.picurl}',intro = '${l.intro}'  where id = '${l.id}'  `};c({url:"/updateAction",method:"get",params:a}).then((l=>{200===l.status?(e.success("修改数据成功"),i(),s()):e.error(l.msg||"修改数据失败")}))},addVisible:p,handleAdd:()=>{s(),p.value=!0},saveInsert:()=>{p.value=!1;var l=n;""==l.id&&(l.id=0);var a={sql:`insert into filesinfo (id,name,picurl,intro)  values ('${l.id}','${l.name}','${l.picurl}','${l.intro}')`};c({url:"/updateAction",method:"get",params:a}).then((l=>{200===l.status?(e.success("添加数据成功"),i()):e.error(l.msg||"添加数据失败")}))}}}},f=u();o("data-v-6e3b63f5");const h={class:"container"},b={class:"handle-box"},g=p("搜索"),y=p("添加"),V=p("编辑 "),v=p("删除 "),_={class:"pagination"},k=p("选择文件"),w={class:"dialog-footer"},x=p("取 消"),C=p("确 定"),z=p("选择文件"),A={class:"dialog-footer"},q=p("取 消"),S=p("确 定");t();const U=f(((e,l,a,o,t,r)=>{const u=d("el-input"),p=d("el-button"),c=d("el-table-column"),m=d("el-table"),U=d("el-pagination"),$=d("el-form-item"),E=d("el-upload"),I=d("el-form"),D=d("el-dialog");return i(),n("div",null,[s("div",h,[s("div",b,[s(u,{modelValue:o.query.keyword,"onUpdate:modelValue":l[1]||(l[1]=e=>o.query.keyword=e),placeholder:"搜索内容",size:"mini",style:{width:"15%","min-width":"100px"},class:"handle-input mr10"},null,8,["modelValue"]),s(p,{type:"primary",icon:"el-icon-search",size:"mini",onClick:o.handleSearch},{default:f((()=>[g])),_:1},8,["onClick"]),s(p,{type:"primary",icon:"el-icon-plus",size:"mini",onClick:o.handleAdd},{default:f((()=>[y])),_:1},8,["onClick"])]),s(m,{data:o.tableData,size:"mini",border:"",class:"table",ref:"multipleTable","header-cell-class-name":"table-header"},{default:f((()=>[s(c,{prop:"id",label:"编号"}),s(c,{prop:"name",label:"名称"}),s(c,{label:"路径(查看大图)",align:"center"},{default:f((e=>[s("a",{href:e.row.picurl,class:"btn btn-danger"},"下载",8,["href"])])),_:1}),s(c,{prop:"intro",label:"介绍"}),s(c,{label:"操作",width:"180",align:"center"},{default:f((e=>[s(p,{type:"text",icon:"el-icon-edit",onClick:l=>o.handleEdit(e.$index,e.row)},{default:f((()=>[V])),_:2},1032,["onClick"]),s(p,{type:"text",icon:"el-icon-delete",class:"red",onClick:l=>o.handleDelete(e.$index,e.row)},{default:f((()=>[v])),_:2},1032,["onClick"])])),_:1})])),_:1},8,["data"]),s("div",_,[s(U,{background:"",layout:"total, prev, pager, next","current-page":o.query.pageIndex,"page-size":o.query.pageSize,total:o.pageTotal,onCurrentChange:o.handlePageChange},null,8,["current-page","page-size","total","onCurrentChange"])])]),s(D,{title:"添加",modelValue:o.addVisible,"onUpdate:modelValue":l[6]||(l[6]=e=>o.addVisible=e),width:"45%"},{footer:f((()=>[s("span",w,[s(p,{size:"small",onClick:l[5]||(l[5]=e=>o.addVisible=!1)},{default:f((()=>[x])),_:1}),s(p,{size:"small",type:"primary",onClick:o.saveInsert},{default:f((()=>[C])),_:1},8,["onClick"])])])),default:f((()=>[s(I,{size:"small","label-width":"100px"},{default:f((()=>[s($,{label:"名称:"},{default:f((()=>[s(u,{placeholder:"请输入名称",modelValue:o.form.name,"onUpdate:modelValue":l[2]||(l[2]=e=>o.form.name=e)},null,8,["modelValue"])])),_:1}),s($,{label:"路径:"},{default:f((()=>[s(u,{placeholder:"请输入路径",style:{width:"80%",display:"inline-block"},modelValue:o.form.picurl,"onUpdate:modelValue":l[3]||(l[3]=e=>o.form.picurl=e)},null,8,["modelValue"]),s(E,{action:"","show-file-list":!1,"on-error":r.handleAvatarError,"on-success":r.handleAvatarSuccess,"before-upload":r.handleAvatarBeforeUpload,"http-request":r.uploadSectionFile,style:{display:"inline-block"}},{default:f((()=>[s(p,{type:"primary",style:{margin:"0px",padding:"0px 8px"}},{default:f((()=>[k])),_:1})])),_:1},8,["on-error","on-success","before-upload","http-request"])])),_:1}),s($,{label:"介绍:"},{default:f((()=>[s(u,{placeholder:"请输入介绍",modelValue:o.form.intro,"onUpdate:modelValue":l[4]||(l[4]=e=>o.form.intro=e)},null,8,["modelValue"])])),_:1})])),_:1})])),_:1},8,["modelValue"]),s(D,{title:"编辑",modelValue:o.editVisible,"onUpdate:modelValue":l[12]||(l[12]=e=>o.editVisible=e),width:"45%"},{footer:f((()=>[s("span",A,[s(p,{size:"small",onClick:l[11]||(l[11]=e=>o.editVisible=!1)},{default:f((()=>[q])),_:1}),s(p,{size:"small",type:"primary",onClick:o.saveEdit},{default:f((()=>[S])),_:1},8,["onClick"])])])),default:f((()=>[s(I,{size:"small","label-width":"100px"},{default:f((()=>[s($,{label:"编号:"},{default:f((()=>[s(u,{placeholder:"请输入编号",disabled:!0,modelValue:o.form.id,"onUpdate:modelValue":l[7]||(l[7]=e=>o.form.id=e)},null,8,["modelValue"])])),_:1}),s($,{label:"名称:"},{default:f((()=>[s(u,{placeholder:"请输入名称",modelValue:o.form.name,"onUpdate:modelValue":l[8]||(l[8]=e=>o.form.name=e)},null,8,["modelValue"])])),_:1}),s($,{label:"路径:"},{default:f((()=>[s(u,{placeholder:"请输入路径",style:{width:"80%",display:"inline-block"},modelValue:o.form.picurl,"onUpdate:modelValue":l[9]||(l[9]=e=>o.form.picurl=e)},null,8,["modelValue"]),s(E,{action:"","show-file-list":!1,"on-error":r.handleAvatarError,"on-success":r.handleAvatarSuccess,"before-upload":r.handleAvatarBeforeUpload,"http-request":r.uploadSectionFile,style:{display:"inline-block"}},{default:f((()=>[s(p,{type:"primary",style:{margin:"0px",padding:"0px 8px"}},{default:f((()=>[z])),_:1})])),_:1},8,["on-error","on-success","before-upload","http-request"])])),_:1}),s($,{label:"介绍:"},{default:f((()=>[s(u,{placeholder:"请输入介绍",modelValue:o.form.intro,"onUpdate:modelValue":l[10]||(l[10]=e=>o.form.intro=e)},null,8,["modelValue"])])),_:1})])),_:1})])),_:1},8,["modelValue"])])}));m.render=U,m.__scopeId="data-v-6e3b63f5";export default m;