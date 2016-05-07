<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/i18next-1.7.7.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/i18next.amd.withJQuery-1.7.7.min.js"></script>
<script type="text/javascript">
   var i18next;
                           
   /** Get lng */                 
   var lng = window.navigator.language;
   if(lng != null && lng !=""){
      lng = lng.substring(0,2).toLowerCase();
   }else{
      lng = "dev";
   }
   
    /** I18n init */ 
   $(function(){
      i18nInit();
   });
   
   /** I18n init function */
   function i18nInit(){
      var option = {lng:lng,resGetPath:'${pageContext.request.contextPath}/locales/__lng__/translation.json',useLocalStorage:false,lowerCaseLng:true};
      i18n.init(option,function(t){
         $("body").i18n(); 
         i18next = t;
      });
   }
</script>