
var projectName = '居家养老系统';
/**
 * 轮播图配置
 */
var swiper = {
	// 设定轮播容器宽度，支持像素和百分比
	width: '100%',
	height: '400px',
	// hover（悬停显示）
	// always（始终显示）
	// none（始终不显示）
	arrow: 'none',
	// default（左右切换）
	// updown（上下切换）
	// fade（渐隐渐显切换）
	anim: 'default',
	// 自动切换的时间间隔
	// 默认3000
	interval: 2000,
	// 指示器位置
	// inside（容器内部）
	// outside（容器外部）
	// none（不显示）
	indicator: 'outside'
}

/**
 * 个人中心菜单
 */
var centerMenu = [{
	name: '个人中心',
	url: '../' + localStorage.getItem('userTable') + '/center.html'
}, 
]


var indexNav = [

{
	name: '老人档案',
	url: './pages/laorendangan/list.html'
}, 
{
	name: '订单申请',
	url: './pages/dingdanshenqing/list.html'
}, 
{
	name: '订单信息',
	url: './pages/dingdanxinxi/list.html'
}, 
{
	name: '转诊信息',
	url: './pages/zhuanzhenxinxi/list.html'
}, 
{
	name: '生活服务',
	url: './pages/shenghuofuwu/list.html'
}, 
{
	name: '服务记录',
	url: './pages/fuwujilu/list.html'
}, 

{
	name: '通告资讯',
	url: './pages/news/list.html'
},
]

var adminurl =  "http://localhost:8080/ssmvr18o/admin/dist/index.html";

var cartFlag = false

var chatFlag = false


chatFlag = true


var menu = [{"backMenu":[{"child":[{"buttons":["新增","查看","修改","删除","生成档案"],"menu":"老人账号","menuJump":"列表","tableName":"laorenzhanghao"}],"menu":"老人账号管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"工作人员","menuJump":"列表","tableName":"gongzuorenyuan"}],"menu":"工作人员管理"},{"child":[{"buttons":["新增","查看","修改","删除","转诊","新建订单"],"menu":"老人档案","menuJump":"列表","tableName":"laorendangan"}],"menu":"老人档案管理"},{"child":[{"buttons":["新增","查看","修改","删除","审核","派单"],"menu":"订单申请","menuJump":"列表","tableName":"dingdanshenqing"}],"menu":"订单申请管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"检查检验项目","menuJump":"列表","tableName":"jianchajianyanxiangmu"}],"menu":"检查检验项目管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"维修服务","menuJump":"列表","tableName":"weixiufuwu"}],"menu":"维修服务管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"订单信息","menuJump":"列表","tableName":"dingdanxinxi"}],"menu":"订单信息管理"},{"child":[{"buttons":["查看","修改","删除"],"menu":"转诊信息","menuJump":"列表","tableName":"zhuanzhenxinxi"}],"menu":"转诊信息管理"},{"child":[{"buttons":["新增","查看","修改","删除","服务"],"menu":"生活服务","menuJump":"列表","tableName":"shenghuofuwu"}],"menu":"生活服务管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"服务记录","menuJump":"列表","tableName":"fuwujilu"}],"menu":"服务记录管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"生活用品信息","menuJump":"列表","tableName":"shenghuoyongpinxinxi"}],"menu":"生活用品信息管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"药品信息","menuJump":"列表","tableName":"yaopinxinxi"}],"menu":"药品信息管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"食物信息","menuJump":"列表","tableName":"shiwuxinxi"}],"menu":"食物信息管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"通告资讯","tableName":"news"},{"buttons":["新增","查看","修改","删除"],"menu":"客服咨询","tableName":"chat"},{"buttons":["查看","修改"],"menu":"轮播图管理","tableName":"config"}],"menu":"系统管理"}],"frontMenu":[{"child":[{"buttons":["查看","新建订单"],"menu":"老人档案列表","menuJump":"列表","tableName":"laorendangan"}],"menu":"老人档案模块"},{"child":[{"buttons":["新增"],"menu":"订单申请列表","menuJump":"列表","tableName":"dingdanshenqing"}],"menu":"订单申请模块"},{"child":[{"buttons":["查看"],"menu":"订单信息列表","menuJump":"列表","tableName":"dingdanxinxi"}],"menu":"订单信息模块"},{"child":[{"buttons":["查看"],"menu":"转诊信息列表","menuJump":"列表","tableName":"zhuanzhenxinxi"}],"menu":"转诊信息模块"},{"child":[{"buttons":["新增"],"menu":"生活服务列表","menuJump":"列表","tableName":"shenghuofuwu"}],"menu":"生活服务模块"},{"child":[{"buttons":["查看"],"menu":"服务记录列表","menuJump":"列表","tableName":"fuwujilu"}],"menu":"服务记录模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"管理员","tableName":"users"},{"backMenu":[{"child":[{"buttons":["查看","新建订单"],"menu":"老人档案","menuJump":"列表","tableName":"laorendangan"}],"menu":"老人档案管理"},{"child":[{"buttons":["新增","查看"],"menu":"订单申请","menuJump":"列表","tableName":"dingdanshenqing"}],"menu":"订单申请管理"},{"child":[{"buttons":["查看"],"menu":"订单信息","menuJump":"列表","tableName":"dingdanxinxi"}],"menu":"订单信息管理"},{"child":[{"buttons":["查看"],"menu":"转诊信息","menuJump":"列表","tableName":"zhuanzhenxinxi"}],"menu":"转诊信息管理"},{"child":[{"buttons":["新增","查看"],"menu":"生活服务","menuJump":"列表","tableName":"shenghuofuwu"}],"menu":"生活服务管理"},{"child":[{"buttons":["查看"],"menu":"服务记录","menuJump":"列表","tableName":"fuwujilu"}],"menu":"服务记录管理"}],"frontMenu":[{"child":[{"buttons":["查看","新建订单"],"menu":"老人档案列表","menuJump":"列表","tableName":"laorendangan"}],"menu":"老人档案模块"},{"child":[{"buttons":["新增"],"menu":"订单申请列表","menuJump":"列表","tableName":"dingdanshenqing"}],"menu":"订单申请模块"},{"child":[{"buttons":["查看"],"menu":"订单信息列表","menuJump":"列表","tableName":"dingdanxinxi"}],"menu":"订单信息模块"},{"child":[{"buttons":["查看"],"menu":"转诊信息列表","menuJump":"列表","tableName":"zhuanzhenxinxi"}],"menu":"转诊信息模块"},{"child":[{"buttons":["新增"],"menu":"生活服务列表","menuJump":"列表","tableName":"shenghuofuwu"}],"menu":"生活服务模块"},{"child":[{"buttons":["查看"],"menu":"服务记录列表","menuJump":"列表","tableName":"fuwujilu"}],"menu":"服务记录模块"}],"hasBackLogin":"否","hasBackRegister":"否","hasFrontLogin":"是","hasFrontRegister":"是","roleName":"老人账号","tableName":"laorenzhanghao"},{"backMenu":[{"child":[{"buttons":["查看","转诊"],"menu":"老人档案","menuJump":"列表","tableName":"laorendangan"}],"menu":"老人档案管理"},{"child":[{"buttons":["查看"],"menu":"订单信息","menuJump":"列表","tableName":"dingdanxinxi"}],"menu":"订单信息管理"},{"child":[{"buttons":["查看"],"menu":"转诊信息","menuJump":"列表","tableName":"zhuanzhenxinxi"}],"menu":"转诊信息管理"},{"child":[{"buttons":["查看","服务"],"menu":"生活服务","menuJump":"列表","tableName":"shenghuofuwu"}],"menu":"生活服务管理"},{"child":[{"buttons":["查看"],"menu":"服务记录","menuJump":"列表","tableName":"fuwujilu"}],"menu":"服务记录管理"}],"frontMenu":[{"child":[{"buttons":["查看","新建订单"],"menu":"老人档案列表","menuJump":"列表","tableName":"laorendangan"}],"menu":"老人档案模块"},{"child":[{"buttons":["新增"],"menu":"订单申请列表","menuJump":"列表","tableName":"dingdanshenqing"}],"menu":"订单申请模块"},{"child":[{"buttons":["查看"],"menu":"订单信息列表","menuJump":"列表","tableName":"dingdanxinxi"}],"menu":"订单信息模块"},{"child":[{"buttons":["查看"],"menu":"转诊信息列表","menuJump":"列表","tableName":"zhuanzhenxinxi"}],"menu":"转诊信息模块"},{"child":[{"buttons":["新增"],"menu":"生活服务列表","menuJump":"列表","tableName":"shenghuofuwu"}],"menu":"生活服务模块"},{"child":[{"buttons":["查看"],"menu":"服务记录列表","menuJump":"列表","tableName":"fuwujilu"}],"menu":"服务记录模块"}],"hasBackLogin":"是","hasBackRegister":"是","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"工作人员","tableName":"gongzuorenyuan"}]


var isAuth = function (tableName,key) {
    let role = localStorage.getItem("userTable");
    let menus = menu;
    for(let i=0;i<menus.length;i++){
        if(menus[i].tableName==role){
            for(let j=0;j<menus[i].backMenu.length;j++){
                for(let k=0;k<menus[i].backMenu[j].child.length;k++){
                    if(tableName==menus[i].backMenu[j].child[k].tableName){
                        let buttons = menus[i].backMenu[j].child[k].buttons.join(',');
                        return buttons.indexOf(key) !== -1 || false
                    }
                }
            }
        }
    }
    return false;
}

var isFrontAuth = function (tableName,key) {
    let role = localStorage.getItem("userTable");
    let menus = menu;
    for(let i=0;i<menus.length;i++){
        if(menus[i].tableName==role){
            for(let j=0;j<menus[i].frontMenu.length;j++){
                for(let k=0;k<menus[i].frontMenu[j].child.length;k++){
                    if(tableName==menus[i].frontMenu[j].child[k].tableName){
                        let buttons = menus[i].frontMenu[j].child[k].buttons.join(',');
                        return buttons.indexOf(key) !== -1 || false
                    }
                }
            }
        }
    }
    return false;
}
