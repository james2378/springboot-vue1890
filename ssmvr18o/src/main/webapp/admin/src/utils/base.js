const base = {
    get() {
        return {
            url : "http://localhost:8080/ssmvr18o/",
            name: "ssmvr18o",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/ssmvr18o/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "居家养老系统"
        } 
    }
}
export default base
