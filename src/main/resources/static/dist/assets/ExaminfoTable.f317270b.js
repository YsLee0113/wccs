import{A as e,B as l,p as a,a as d,L as o,z as t,r as n,o as i,c as r,f as u,w as m,h as s}from"./vendor.a8d67b6f.js";import{s as p}from"./request.7ef930c0.js";const f={name:"ExaminfoTable",setup(){const a=e({keyword:"",pageIndex:1,pageSize:10}),d=l([]),n=l(0),i=()=>{p({url:"/examinfo/apilist",method:"get",params:a}).then((e=>{d.value=e.data.list,n.value=e.data.pageTotal||10}))};i();let r=e({id:"",name:"",fenshu:"",xuanxiang:"",answer:"",tid:"",intro:"",addtime:""});const u=()=>{Object.keys(r).forEach((e=>r[e]="")),console.log("clear")},m=l(!1),s=l(!1);return{query:a,tableData:d,pageTotal:n,editVisible:m,form:r,handleSearch:()=>{a.pageIndex=1,i()},handlePageChange:e=>{a.pageIndex=e,i()},handleDelete:(e,l)=>{o.confirm("确定要删除吗？","提示",{type:"warning"}).then((()=>{p({url:"/examinfo/apidelete",method:"get",params:{id:l.id}}).then((e=>{200===e.status?(t.success("删除成功"),i()):t.error(e.msg||"删除失败")}))})).catch((()=>{}))},handleEdit:(e,l)=>{Object.keys(r).forEach((e=>{r[e]=l[e]})),m.value=!0},saveEdit:()=>{m.value=!1,p({url:"/examinfo/apiupdate",method:"get",params:r}).then((e=>{200===e.status?(t.success("修改数据成功"),i(),u()):t.error(e.msg||"修改数据失败")}))},addVisible:s,handleAdd:()=>{u(),s.value=!0},saveInsert:()=>{s.value=!1,p({url:"/examinfo/apiinsert",method:"get",params:r}).then((e=>{200===e.status?(t.success("添加数据成功"),i()):t.error(e.msg||"添加数据失败")}))}}}},c=m();a("data-v-715e0cea");const h={class:"container"},V={class:"handle-box"},b=s("搜索"),g=s("添加"),x=s("编辑 "),_=s("删除"),y={class:"pagination"},k={class:"dialog-footer"},w=s("取 消"),C=s("确 定"),v={class:"dialog-footer"},U=s("取 消"),z=s("确 定");d();const I=c(((e,l,a,d,o,t)=>{const m=n("el-input"),s=n("el-button"),p=n("el-table-column"),f=n("el-table"),I=n("el-pagination"),D=n("el-form-item"),E=n("el-form"),q=n("el-dialog");return i(),r("div",null,[u("div",h,[u("div",V,[u(m,{modelValue:d.query.keyword,"onUpdate:modelValue":l[1]||(l[1]=e=>d.query.keyword=e),placeholder:"搜索内容",size:"mini",style:{width:"15%","min-width":"100px"},class:"handle-input mr10"},null,8,["modelValue"]),u(s,{type:"primary",icon:"el-icon-search",size:"mini",onClick:d.handleSearch},{default:c((()=>[b])),_:1},8,["onClick"]),u(s,{type:"primary",icon:"el-icon-plus",size:"mini",onClick:d.handleAdd},{default:c((()=>[g])),_:1},8,["onClick"])]),u(f,{data:d.tableData,size:"mini",border:"",class:"table",ref:"multipleTable","header-cell-class-name":"table-header"},{default:c((()=>[u(p,{prop:"id",label:"ID"}),u(p,{prop:"name",label:"题目"}),u(p,{prop:"fenshu",label:"分数"}),u(p,{prop:"xuanxiang",label:"选项"}),u(p,{prop:"answer",label:"答案"}),u(p,{prop:"tid",label:"所属id"}),u(p,{prop:"intro",label:"备注"}),u(p,{prop:"addtime",label:"时间"}),u(p,{label:"操作",width:"180",align:"center"},{default:c((e=>[u(s,{type:"text",icon:"el-icon-edit",onClick:l=>d.handleEdit(e.$index,e.row)},{default:c((()=>[x])),_:2},1032,["onClick"]),u(s,{type:"text",icon:"el-icon-delete",class:"red",onClick:l=>d.handleDelete(e.$index,e.row)},{default:c((()=>[_])),_:2},1032,["onClick"])])),_:1})])),_:1},8,["data"]),u("div",y,[u(I,{background:"",layout:"total, prev, pager, next","current-page":d.query.pageIndex,"page-size":d.query.pageSize,total:d.pageTotal,onCurrentChange:d.handlePageChange},null,8,["current-page","page-size","total","onCurrentChange"])])]),u(q,{title:"添加",modelValue:d.addVisible,"onUpdate:modelValue":l[10]||(l[10]=e=>d.addVisible=e),width:"30%"},{footer:c((()=>[u("span",k,[u(s,{size:"small",onClick:l[9]||(l[9]=e=>d.addVisible=!1)},{default:c((()=>[w])),_:1}),u(s,{size:"small",type:"primary",onClick:d.saveInsert},{default:c((()=>[C])),_:1},8,["onClick"])])])),default:c((()=>[u(E,{size:"small","label-width":"100px"},{default:c((()=>[u(D,{label:"题目:"},{default:c((()=>[u(m,{placeholder:"请输入题目",modelValue:d.form.name,"onUpdate:modelValue":l[2]||(l[2]=e=>d.form.name=e)},null,8,["modelValue"])])),_:1}),u(D,{label:"分数:"},{default:c((()=>[u(m,{placeholder:"请输入分数",modelValue:d.form.fenshu,"onUpdate:modelValue":l[3]||(l[3]=e=>d.form.fenshu=e)},null,8,["modelValue"])])),_:1}),u(D,{label:"选项:"},{default:c((()=>[u(m,{placeholder:"请输入选项",modelValue:d.form.xuanxiang,"onUpdate:modelValue":l[4]||(l[4]=e=>d.form.xuanxiang=e)},null,8,["modelValue"])])),_:1}),u(D,{label:"答案:"},{default:c((()=>[u(m,{placeholder:"请输入答案",modelValue:d.form.answer,"onUpdate:modelValue":l[5]||(l[5]=e=>d.form.answer=e)},null,8,["modelValue"])])),_:1}),u(D,{label:"所属id:"},{default:c((()=>[u(m,{placeholder:"请输入所属id",modelValue:d.form.tid,"onUpdate:modelValue":l[6]||(l[6]=e=>d.form.tid=e)},null,8,["modelValue"])])),_:1}),u(D,{label:"备注:"},{default:c((()=>[u(m,{placeholder:"请输入备注",modelValue:d.form.intro,"onUpdate:modelValue":l[7]||(l[7]=e=>d.form.intro=e)},null,8,["modelValue"])])),_:1}),u(D,{label:"时间:"},{default:c((()=>[u(m,{placeholder:"请输入时间",modelValue:d.form.addtime,"onUpdate:modelValue":l[8]||(l[8]=e=>d.form.addtime=e)},null,8,["modelValue"])])),_:1})])),_:1})])),_:1},8,["modelValue"]),u(q,{title:"编辑",modelValue:d.editVisible,"onUpdate:modelValue":l[20]||(l[20]=e=>d.editVisible=e),width:"30%"},{footer:c((()=>[u("span",v,[u(s,{size:"small",onClick:l[19]||(l[19]=e=>d.editVisible=!1)},{default:c((()=>[U])),_:1}),u(s,{size:"small",type:"primary",onClick:d.saveEdit},{default:c((()=>[z])),_:1},8,["onClick"])])])),default:c((()=>[u(E,{size:"small","label-width":"100px"},{default:c((()=>[u(D,{label:"ID:"},{default:c((()=>[u(m,{placeholder:"请输入ID",disabled:!0,modelValue:d.form.id,"onUpdate:modelValue":l[11]||(l[11]=e=>d.form.id=e)},null,8,["modelValue"])])),_:1}),u(D,{label:"题目:"},{default:c((()=>[u(m,{placeholder:"请输入题目",modelValue:d.form.name,"onUpdate:modelValue":l[12]||(l[12]=e=>d.form.name=e)},null,8,["modelValue"])])),_:1}),u(D,{label:"分数:"},{default:c((()=>[u(m,{placeholder:"请输入分数",modelValue:d.form.fenshu,"onUpdate:modelValue":l[13]||(l[13]=e=>d.form.fenshu=e)},null,8,["modelValue"])])),_:1}),u(D,{label:"选项:"},{default:c((()=>[u(m,{placeholder:"请输入选项",modelValue:d.form.xuanxiang,"onUpdate:modelValue":l[14]||(l[14]=e=>d.form.xuanxiang=e)},null,8,["modelValue"])])),_:1}),u(D,{label:"答案:"},{default:c((()=>[u(m,{placeholder:"请输入答案",modelValue:d.form.answer,"onUpdate:modelValue":l[15]||(l[15]=e=>d.form.answer=e)},null,8,["modelValue"])])),_:1}),u(D,{label:"所属id:"},{default:c((()=>[u(m,{placeholder:"请输入所属id",modelValue:d.form.tid,"onUpdate:modelValue":l[16]||(l[16]=e=>d.form.tid=e)},null,8,["modelValue"])])),_:1}),u(D,{label:"备注:"},{default:c((()=>[u(m,{placeholder:"请输入备注",modelValue:d.form.intro,"onUpdate:modelValue":l[17]||(l[17]=e=>d.form.intro=e)},null,8,["modelValue"])])),_:1}),u(D,{label:"时间:"},{default:c((()=>[u(m,{placeholder:"请输入时间",modelValue:d.form.addtime,"onUpdate:modelValue":l[18]||(l[18]=e=>d.form.addtime=e)},null,8,["modelValue"])])),_:1})])),_:1})])),_:1},8,["modelValue"])])}));f.render=I,f.__scopeId="data-v-715e0cea";export default f;
