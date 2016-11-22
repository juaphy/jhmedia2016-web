<script type="text/javascript">
            function getFile(obj,inputName){
                var file_name = $(obj).val();
                $("input[name='"+inputName+"']").val(file_name);
               setImagePreviews();
            }
</script>