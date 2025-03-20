<template>
  <div class="addEdit-block">
    <el-form
      class="detail-form-content"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="80px"
	  :style="{backgroundColor:addEditForm.addEditBoxColor}"
    >
      <el-row>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="老人账号" prop="laorenzhanghao">
          <el-input v-model="ruleForm.laorenzhanghao" 
              placeholder="老人账号" clearable  :readonly="ro.laorenzhanghao"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="老人账号" prop="laorenzhanghao">
              <el-input v-model="ruleForm.laorenzhanghao" 
                placeholder="老人账号" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="老人姓名" prop="laorenxingming">
          <el-input v-model="ruleForm.laorenxingming" 
              placeholder="老人姓名" clearable  :readonly="ro.laorenxingming"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="老人姓名" prop="laorenxingming">
              <el-input v-model="ruleForm.laorenxingming" 
                placeholder="老人姓名" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="select" v-if="type!='info'"  label="老人性别" prop="laorenxingbie">
          <el-select v-model="ruleForm.laorenxingbie" placeholder="请选择老人性别">
            <el-option
                v-for="(item,index) in laorenxingbieOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="老人性别" prop="laorenxingbie">
	      <el-input v-model="ruleForm.laorenxingbie"
                placeholder="老人性别" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="老人年龄" prop="laorennianling">
          <el-input v-model="ruleForm.laorennianling" 
              placeholder="老人年龄" clearable  :readonly="ro.laorennianling"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="老人年龄" prop="laorennianling">
              <el-input v-model="ruleForm.laorennianling" 
                placeholder="老人年龄" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="24">  
        <el-form-item class="upload" v-if="type!='info' && !ro.laorenzhaopian" label="老人照片" prop="laorenzhaopian">
          <file-upload
          tip="点击上传老人照片"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.laorenzhaopian?ruleForm.laorenzhaopian:''"
          @change="laorenzhaopianUploadChange"
          ></file-upload>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.laorenzhaopian" label="老人照片" prop="laorenzhaopian">
            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.laorenzhaopian.split(',')" :src="item" width="100" height="100">
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="联系电话" prop="lianxidianhua">
          <el-input v-model="ruleForm.lianxidianhua" 
              placeholder="联系电话" clearable  :readonly="ro.lianxidianhua"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="联系电话" prop="lianxidianhua">
              <el-input v-model="ruleForm.lianxidianhua" 
                placeholder="联系电话" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="联系地址" prop="lianxidizhi">
          <el-input v-model="ruleForm.lianxidizhi" 
              placeholder="联系地址" clearable  :readonly="ro.lianxidizhi"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="联系地址" prop="lianxidizhi">
              <el-input v-model="ruleForm.lianxidizhi" 
                placeholder="联系地址" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="24">  
        <el-form-item class="upload" v-if="type!='info'" label="病例" prop="bingli">
          <file-upload
          tip="点击上传病例"
          action="file/upload"
          :limit="1"
          :multiple="true"
          :fileUrls="ruleForm.bingli?ruleForm.bingli:''"
          @change="bingliUploadChange"
          ></file-upload>
        </el-form-item>  
        <div v-else>
          <el-form-item v-if="ruleForm.bingli" label="病例" prop="bingli">
            <el-button type="text" size="small" @click="download(ruleForm.bingli)">下载</el-button>
          </el-form-item>
        </div>    
      </el-col>      
      <el-col :span="12">
        <el-form-item class="date" v-if="type!='info'" label="日期" prop="riqi">
            <el-date-picker
                format="yyyy 年 MM 月 dd 日"
                value-format="yyyy-MM-dd"
                v-model="ruleForm.riqi" 
                type="date"
                placeholder="日期">
            </el-date-picker> 
        </el-form-item>
        <div v-else>
          <el-form-item class="input" v-if="ruleForm.riqi" label="日期" prop="riqi">
              <el-input v-model="ruleForm.riqi" 
                placeholder="日期" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="原医院" prop="yuanyiyuan">
          <el-input v-model="ruleForm.yuanyiyuan" 
              placeholder="原医院" clearable  :readonly="ro.yuanyiyuan"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="原医院" prop="yuanyiyuan">
              <el-input v-model="ruleForm.yuanyiyuan" 
                placeholder="原医院" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="现医院" prop="xianyiyuan">
          <el-input v-model="ruleForm.xianyiyuan" 
              placeholder="现医院" clearable  :readonly="ro.xianyiyuan"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="现医院" prop="xianyiyuan">
              <el-input v-model="ruleForm.xianyiyuan" 
                placeholder="现医院" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="转诊医院" prop="zhuanzhenyiyuan">
          <el-input v-model="ruleForm.zhuanzhenyiyuan" 
              placeholder="转诊医院" clearable  :readonly="ro.zhuanzhenyiyuan"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="转诊医院" prop="zhuanzhenyiyuan">
              <el-input v-model="ruleForm.zhuanzhenyiyuan" 
                placeholder="转诊医院" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      </el-row>
          <el-row>
            <el-col :span="24">
              <el-form-item class="textarea" v-if="type!='info'" label="转诊原因" prop="zhuanzhenyuanyin">
                <el-input
                  style="min-width: 200px; max-width: 600px;"
                  type="textarea"
                  :rows="8"
                  placeholder="转诊原因"
                  v-model="ruleForm.zhuanzhenyuanyin" >
                </el-input>
              </el-form-item>
              <div v-else>
                <el-form-item v-if="ruleForm.zhuanzhenyuanyin" label="转诊原因" prop="zhuanzhenyuanyin">
                    <span>{{ruleForm.zhuanzhenyuanyin}}</span>
                </el-form-item>
              </div>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="24">
              <el-form-item class="textarea" v-if="type!='info'" label="主要现病史" prop="zhuyaoxianbingshi">
                <el-input
                  style="min-width: 200px; max-width: 600px;"
                  type="textarea"
                  :rows="8"
                  placeholder="主要现病史"
                  v-model="ruleForm.zhuyaoxianbingshi" >
                </el-input>
              </el-form-item>
              <div v-else>
                <el-form-item v-if="ruleForm.zhuyaoxianbingshi" label="主要现病史" prop="zhuyaoxianbingshi">
                    <span>{{ruleForm.zhuyaoxianbingshi}}</span>
                </el-form-item>
              </div>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="24">
              <el-form-item class="textarea" v-if="type!='info'" label="既往病史" prop="jiwangbingshi">
                <el-input
                  style="min-width: 200px; max-width: 600px;"
                  type="textarea"
                  :rows="8"
                  placeholder="既往病史"
                  v-model="ruleForm.jiwangbingshi" >
                </el-input>
              </el-form-item>
              <div v-else>
                <el-form-item v-if="ruleForm.jiwangbingshi" label="既往病史" prop="jiwangbingshi">
                    <span>{{ruleForm.jiwangbingshi}}</span>
                </el-form-item>
              </div>
            </el-col>
          </el-row>
      <el-form-item class="btn">
        <el-button v-if="type!='info'" type="primary" class="btn-success" @click="onSubmit">提交</el-button>
        <el-button v-if="type!='info'" class="btn-close" @click="back()">取消</el-button>
        <el-button v-if="type=='info'" class="btn-close" @click="back()">返回</el-button>
      </el-form-item>
    </el-form>
    

  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
export default {
  data() {
    let self = this
    var validateIdCard = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!checkIdCard(value)) {
        callback(new Error("请输入正确的身份证号码"));
      } else {
        callback();
      }
    };
    var validateUrl = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isURL(value)) {
        callback(new Error("请输入正确的URL地址"));
      } else {
        callback();
      }
    };
    var validateMobile = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isMobile(value)) {
        callback(new Error("请输入正确的手机号码"));
      } else {
        callback();
      }
    };
    var validatePhone = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isPhone(value)) {
        callback(new Error("请输入正确的电话号码"));
      } else {
        callback();
      }
    };
    var validateEmail = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isEmail(value)) {
        callback(new Error("请输入正确的邮箱地址"));
      } else {
        callback();
      }
    };
    var validateNumber = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isNumber(value)) {
        callback(new Error("请输入数字"));
      } else {
        callback();
      }
    };
    var validateIntNumber = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isIntNumer(value)) {
        callback(new Error("请输入整数"));
      } else {
        callback();
      }
    };
    return {
	  addEditForm: {"btnSaveFontColor":"#fff","selectFontSize":"14px","btnCancelBorderColor":"#DCDFE6","inputBorderRadius":"4px","inputFontSize":"14px","textareaBgColor":"#fff","btnSaveFontSize":"14px","textareaBorderRadius":"4px","uploadBgColor":"#fff","textareaBorderStyle":"solid","btnCancelWidth":"88px","textareaHeight":"120px","dateBgColor":"#fff","btnSaveBorderRadius":"4px","uploadLableFontSize":"14px","textareaBorderWidth":"1px","inputLableColor":"#606266","addEditBoxColor":"#fff","dateIconFontSize":"14px","btnSaveBgColor":"rgba(36, 194, 205, 1)","uploadIconFontColor":"#8c939d","textareaBorderColor":"#DCDFE6","btnCancelBgColor":"#ecf5ff","selectLableColor":"#606266","btnSaveBorderStyle":"solid","dateBorderWidth":"1px","dateLableFontSize":"14px","dateBorderRadius":"4px","btnCancelBorderStyle":"solid","selectLableFontSize":"14px","selectBorderStyle":"solid","selectIconFontColor":"#C0C4CC","btnCancelHeight":"44px","inputHeight":"40px","btnCancelFontColor":"#606266","dateBorderColor":"#DCDFE6","dateIconFontColor":"#C0C4CC","uploadBorderStyle":"solid","dateBorderStyle":"solid","dateLableColor":"#606266","dateFontSize":"14px","inputBorderWidth":"1px","uploadIconFontSize":"28px","selectHeight":"40px","inputFontColor":"#606266","uploadHeight":"148px","textareaLableColor":"#606266","textareaLableFontSize":"14px","btnCancelFontSize":"14px","inputBorderStyle":"solid","btnCancelBorderRadius":"4px","inputBgColor":"#fff","inputLableFontSize":"14px","uploadLableColor":"#606266","uploadBorderRadius":"4px","btnSaveHeight":"44px","selectBgColor":"#fff","btnSaveWidth":"88px","selectIconFontSize":"14px","dateHeight":"40px","selectBorderColor":"#DCDFE6","inputBorderColor":"#DCDFE6","uploadBorderColor":"#DCDFE6","textareaFontColor":"#606266","selectBorderWidth":"1px","dateFontColor":"#606266","btnCancelBorderWidth":"1px","uploadBorderWidth":"1px","textareaFontSize":"14px","selectBorderRadius":"4px","selectFontColor":"#606266","btnSaveBorderColor":"#409EFF","btnSaveBorderWidth":"0px"},
      id: '',
      type: '',
      ro:{
	laorenzhanghao : false,
	laorenxingming : false,
	laorenxingbie : false,
	laorennianling : false,
	laorenzhaopian : false,
	lianxidianhua : false,
	lianxidizhi : false,
	zhuanzhenyuanyin : false,
	zhuyaoxianbingshi : false,
	jiwangbingshi : false,
	bingli : false,
	riqi : false,
	yuanyiyuan : false,
	xianyiyuan : false,
	zhuanzhenyiyuan : false,
	userid : false,
      },
      ruleForm: {
        laorenzhanghao: '',
        laorenxingming: '',
        laorenxingbie: '',
        laorennianling: '',
        laorenzhaopian: '',
        lianxidianhua: '',
        lianxidizhi: '',
        zhuanzhenyuanyin: '',
        zhuyaoxianbingshi: '',
        jiwangbingshi: '',
        bingli: '',
        riqi: '',
        yuanyiyuan: '',
        xianyiyuan: '',
        zhuanzhenyiyuan: '',
        userid: '',
      },
          laorenxingbieOptions: [],
      rules: {
          laorenzhanghao: [
                { required: true, message: '老人账号不能为空', trigger: 'blur' },
          ],
          laorenxingming: [
          ],
          laorenxingbie: [
          ],
          laorennianling: [
          ],
          laorenzhaopian: [
          ],
          lianxidianhua: [
          ],
          lianxidizhi: [
          ],
          zhuanzhenyuanyin: [
          ],
          zhuyaoxianbingshi: [
          ],
          jiwangbingshi: [
          ],
          bingli: [
          ],
          riqi: [
          ],
          yuanyiyuan: [
          ],
          xianyiyuan: [
          ],
          zhuanzhenyiyuan: [
          ],
          userid: [
          ],
      }
    };
  },
  props: ["parent"],
  computed: {
  },
  created() {
	this.ruleForm.riqi = this.getCurDate()
	this.addEditStyleChange()
	this.addEditUploadStyleChange()
  },
  methods: {
    // 下载
    download(file){
      window.open(`${file}`)
    },
    // 初始化
    init(id,type) {
      if (id) {
        this.id = id;
        this.type = type;
      }
      if(this.type=='info'||this.type=='else'){
        this.info(id);
      }else if(this.type=='cross'){
        var obj = this.$storage.getObj('crossObj');
        for (var o in obj){
          if(o=='laorenzhanghao'){
            this.ruleForm.laorenzhanghao = obj[o];
	    this.ro.laorenzhanghao = true;
            continue;
          }
          if(o=='laorenxingming'){
            this.ruleForm.laorenxingming = obj[o];
	    this.ro.laorenxingming = true;
            continue;
          }
          if(o=='laorenxingbie'){
            this.ruleForm.laorenxingbie = obj[o];
	    this.ro.laorenxingbie = true;
            continue;
          }
          if(o=='laorennianling'){
            this.ruleForm.laorennianling = obj[o];
	    this.ro.laorennianling = true;
            continue;
          }
          if(o=='laorenzhaopian'){
            this.ruleForm.laorenzhaopian = obj[o];
	    this.ro.laorenzhaopian = true;
            continue;
          }
          if(o=='lianxidianhua'){
            this.ruleForm.lianxidianhua = obj[o];
	    this.ro.lianxidianhua = true;
            continue;
          }
          if(o=='lianxidizhi'){
            this.ruleForm.lianxidizhi = obj[o];
	    this.ro.lianxidizhi = true;
            continue;
          }
          if(o=='zhuanzhenyuanyin'){
            this.ruleForm.zhuanzhenyuanyin = obj[o];
	    this.ro.zhuanzhenyuanyin = true;
            continue;
          }
          if(o=='zhuyaoxianbingshi'){
            this.ruleForm.zhuyaoxianbingshi = obj[o];
	    this.ro.zhuyaoxianbingshi = true;
            continue;
          }
          if(o=='jiwangbingshi'){
            this.ruleForm.jiwangbingshi = obj[o];
	    this.ro.jiwangbingshi = true;
            continue;
          }
          if(o=='bingli'){
            this.ruleForm.bingli = obj[o];
	    this.ro.bingli = true;
            continue;
          }
          if(o=='riqi'){
            this.ruleForm.riqi = obj[o];
	    this.ro.riqi = true;
            continue;
          }
          if(o=='yuanyiyuan'){
            this.ruleForm.yuanyiyuan = obj[o];
	    this.ro.yuanyiyuan = true;
            continue;
          }
          if(o=='xianyiyuan'){
            this.ruleForm.xianyiyuan = obj[o];
	    this.ro.xianyiyuan = true;
            continue;
          }
          if(o=='zhuanzhenyiyuan'){
            this.ruleForm.zhuanzhenyiyuan = obj[o];
	    this.ro.zhuanzhenyiyuan = true;
            continue;
          }
          if(o=='userid'){
            this.ruleForm.userid = obj[o];
	    this.ro.userid = true;
            continue;
          }
        }
      }
      // 获取用户信息
      this.$http({
        url: `${this.$storage.get('sessionTable')}/session`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
          var json = data.data;
        } else {
          this.$message.error(data.msg);
        }
      });
            this.laorenxingbieOptions = "男,女".split(',')
    },
    // 多级联动参数
    info(id) {
      this.$http({
        url: `zhuanzhenxinxi/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
        this.ruleForm = data.data;
	//解决前台上传图片后台不显示的问题
	let reg=new RegExp('../../../upload','g')//g代表全部
        } else {
          this.$message.error(data.msg);
        }
      });
    },
    // 提交
    onSubmit() {
      // ${column.compare}
      // ${column.compare}
      // ${column.compare}
      // ${column.compare}
      // ${column.compare}
      // ${column.compare}
      // ${column.compare}
      // ${column.compare}
      // ${column.compare}
      // ${column.compare}
      // ${column.compare}
      // ${column.compare}
      // ${column.compare}
      // ${column.compare}
      // ${column.compare}
      // ${column.compare}
















      this.$refs["ruleForm"].validate(valid => {
        if (valid) {
          this.$http({
            url: `zhuanzhenxinxi/${!this.ruleForm.id ? "save" : "update"}`,
            method: "post",
            data: this.ruleForm
          }).then(({ data }) => {
            if (data && data.code === 0) {
              this.$message({
                message: "操作成功",
                type: "success",
                duration: 1500,
                onClose: () => {
                  this.parent.showFlag = true;
                  this.parent.addOrUpdateFlag = false;
                  this.parent.zhuanzhenxinxiCrossAddOrUpdateFlag = false;
                  this.parent.search();
                  this.parent.contentStyleChange();
                }
              });
            } else {
              this.$message.error(data.msg);
            }
          });
        }
      });
    },
    // 获取uuid
    getUUID () {
      return new Date().getTime();
    },
    // 返回
    back() {
      this.parent.showFlag = true;
      this.parent.addOrUpdateFlag = false;
      this.parent.zhuanzhenxinxiCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
    },
    laorenzhaopianUploadChange(fileUrls) {
	this.ruleForm.laorenzhaopian = fileUrls;
			this.addEditUploadStyleChange()
    },
    bingliUploadChange(fileUrls) {
	this.ruleForm.bingli = fileUrls;
			this.addEditUploadStyleChange()
    },
	addEditStyleChange() {
	  this.$nextTick(()=>{
	    // input
	    document.querySelectorAll('.addEdit-block .input .el-input__inner').forEach(el=>{
	      el.style.height = this.addEditForm.inputHeight
	      el.style.color = this.addEditForm.inputFontColor
	      el.style.fontSize = this.addEditForm.inputFontSize
	      el.style.borderWidth = this.addEditForm.inputBorderWidth
	      el.style.borderStyle = this.addEditForm.inputBorderStyle
	      el.style.borderColor = this.addEditForm.inputBorderColor
	      el.style.borderRadius = this.addEditForm.inputBorderRadius
	      el.style.backgroundColor = this.addEditForm.inputBgColor
	    })
	    document.querySelectorAll('.addEdit-block .input .el-form-item__label').forEach(el=>{
	      el.style.lineHeight = this.addEditForm.inputHeight
	      el.style.color = this.addEditForm.inputLableColor
	      el.style.fontSize = this.addEditForm.inputLableFontSize
	    })
	    // select
	    document.querySelectorAll('.addEdit-block .select .el-input__inner').forEach(el=>{
	      el.style.height = this.addEditForm.selectHeight
	      el.style.color = this.addEditForm.selectFontColor
	      el.style.fontSize = this.addEditForm.selectFontSize
	      el.style.borderWidth = this.addEditForm.selectBorderWidth
	      el.style.borderStyle = this.addEditForm.selectBorderStyle
	      el.style.borderColor = this.addEditForm.selectBorderColor
	      el.style.borderRadius = this.addEditForm.selectBorderRadius
	      el.style.backgroundColor = this.addEditForm.selectBgColor
	    })
	    document.querySelectorAll('.addEdit-block .select .el-form-item__label').forEach(el=>{
	      el.style.lineHeight = this.addEditForm.selectHeight
	      el.style.color = this.addEditForm.selectLableColor
	      el.style.fontSize = this.addEditForm.selectLableFontSize
	    })
	    document.querySelectorAll('.addEdit-block .select .el-select__caret').forEach(el=>{
	      el.style.color = this.addEditForm.selectIconFontColor
	      el.style.fontSize = this.addEditForm.selectIconFontSize
	    })
	    // date
	    document.querySelectorAll('.addEdit-block .date .el-input__inner').forEach(el=>{
	      el.style.height = this.addEditForm.dateHeight
	      el.style.color = this.addEditForm.dateFontColor
	      el.style.fontSize = this.addEditForm.dateFontSize
	      el.style.borderWidth = this.addEditForm.dateBorderWidth
	      el.style.borderStyle = this.addEditForm.dateBorderStyle
	      el.style.borderColor = this.addEditForm.dateBorderColor
	      el.style.borderRadius = this.addEditForm.dateBorderRadius
	      el.style.backgroundColor = this.addEditForm.dateBgColor
	    })
	    document.querySelectorAll('.addEdit-block .date .el-form-item__label').forEach(el=>{
	      el.style.lineHeight = this.addEditForm.dateHeight
	      el.style.color = this.addEditForm.dateLableColor
	      el.style.fontSize = this.addEditForm.dateLableFontSize
	    })
	    document.querySelectorAll('.addEdit-block .date .el-input__icon').forEach(el=>{
	      el.style.color = this.addEditForm.dateIconFontColor
	      el.style.fontSize = this.addEditForm.dateIconFontSize
	      el.style.lineHeight = this.addEditForm.dateHeight
	    })
	    // upload
	    let iconLineHeight = parseInt(this.addEditForm.uploadHeight) - parseInt(this.addEditForm.uploadBorderWidth) * 2 + 'px'
	    document.querySelectorAll('.addEdit-block .upload .el-upload--picture-card').forEach(el=>{
	      el.style.width = this.addEditForm.uploadHeight
	      el.style.height = this.addEditForm.uploadHeight
	      el.style.borderWidth = this.addEditForm.uploadBorderWidth
	      el.style.borderStyle = this.addEditForm.uploadBorderStyle
	      el.style.borderColor = this.addEditForm.uploadBorderColor
	      el.style.borderRadius = this.addEditForm.uploadBorderRadius
	      el.style.backgroundColor = this.addEditForm.uploadBgColor
	    })
	    document.querySelectorAll('.addEdit-block .upload .el-form-item__label').forEach(el=>{
	      el.style.lineHeight = this.addEditForm.uploadHeight
	      el.style.color = this.addEditForm.uploadLableColor
	      el.style.fontSize = this.addEditForm.uploadLableFontSize
	    })
	    document.querySelectorAll('.addEdit-block .upload .el-icon-plus').forEach(el=>{
	      el.style.color = this.addEditForm.uploadIconFontColor
	      el.style.fontSize = this.addEditForm.uploadIconFontSize
	      el.style.lineHeight = iconLineHeight
	      el.style.display = 'block'
	    })
	    // 多文本输入框
	    document.querySelectorAll('.addEdit-block .textarea .el-textarea__inner').forEach(el=>{
	      el.style.height = this.addEditForm.textareaHeight
	      el.style.color = this.addEditForm.textareaFontColor
	      el.style.fontSize = this.addEditForm.textareaFontSize
	      el.style.borderWidth = this.addEditForm.textareaBorderWidth
	      el.style.borderStyle = this.addEditForm.textareaBorderStyle
	      el.style.borderColor = this.addEditForm.textareaBorderColor
	      el.style.borderRadius = this.addEditForm.textareaBorderRadius
	      el.style.backgroundColor = this.addEditForm.textareaBgColor
	    })
	    document.querySelectorAll('.addEdit-block .textarea .el-form-item__label').forEach(el=>{
	      // el.style.lineHeight = this.addEditForm.textareaHeight
	      el.style.color = this.addEditForm.textareaLableColor
	      el.style.fontSize = this.addEditForm.textareaLableFontSize
	    })
	    // 保存
	    document.querySelectorAll('.addEdit-block .btn .btn-success').forEach(el=>{
	      el.style.width = this.addEditForm.btnSaveWidth
	      el.style.height = this.addEditForm.btnSaveHeight
	      el.style.color = this.addEditForm.btnSaveFontColor
	      el.style.fontSize = this.addEditForm.btnSaveFontSize
	      el.style.borderWidth = this.addEditForm.btnSaveBorderWidth
	      el.style.borderStyle = this.addEditForm.btnSaveBorderStyle
	      el.style.borderColor = this.addEditForm.btnSaveBorderColor
	      el.style.borderRadius = this.addEditForm.btnSaveBorderRadius
	      el.style.backgroundColor = this.addEditForm.btnSaveBgColor
	    })
	    // 返回
	    document.querySelectorAll('.addEdit-block .btn .btn-close').forEach(el=>{
	      el.style.width = this.addEditForm.btnCancelWidth
	      el.style.height = this.addEditForm.btnCancelHeight
	      el.style.color = this.addEditForm.btnCancelFontColor
	      el.style.fontSize = this.addEditForm.btnCancelFontSize
	      el.style.borderWidth = this.addEditForm.btnCancelBorderWidth
	      el.style.borderStyle = this.addEditForm.btnCancelBorderStyle
	      el.style.borderColor = this.addEditForm.btnCancelBorderColor
	      el.style.borderRadius = this.addEditForm.btnCancelBorderRadius
	      el.style.backgroundColor = this.addEditForm.btnCancelBgColor
	    })
	  })
	},
	addEditUploadStyleChange() {
		this.$nextTick(()=>{
		  document.querySelectorAll('.addEdit-block .upload .el-upload-list--picture-card .el-upload-list__item').forEach(el=>{
			el.style.width = this.addEditForm.uploadHeight
			el.style.height = this.addEditForm.uploadHeight
			el.style.borderWidth = this.addEditForm.uploadBorderWidth
			el.style.borderStyle = this.addEditForm.uploadBorderStyle
			el.style.borderColor = this.addEditForm.uploadBorderColor
			el.style.borderRadius = this.addEditForm.uploadBorderRadius
			el.style.backgroundColor = this.addEditForm.uploadBgColor
		  })
	  })
	},
  }
};
</script>
<style lang="scss">
.editor{
  height: 500px;
  
  & /deep/ .ql-container {
	  height: 310px;
  }
}
.amap-wrapper {
  width: 100%;
  height: 500px;
}
.search-box {
  position: absolute;
}
.addEdit-block {
	margin: -10px;
}
.detail-form-content {
	padding: 12px;
}
.btn .el-button {
  padding: 0;
}
</style>
