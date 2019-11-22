<%--
  Created by IntelliJ IDEA.
  User: tuvsh
  Date: 11/19/2019
  Time: 5:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>
    $(document).ready(function () {
        $('#inputfile').change(function () {
            var file_data = $('#inputfile').prop('files')[0];
            var form_data = new FormData();
            form_data.append('file', file_data);
            $.ajax({
                url: "${pageContext.request.contextPath}/upload",
                type: "POST",
                data: form_data,
                contentType: false,
                cache: false,
                processData: false,
                success: function (data) {
                    console.log(data);
                    $('#image').val(data);
                    $('#foodImage').attr("src","${pageContext.request.contextPath}/upload?imageId="+data);
                },
                error: function(error) {
                    console.log(error);
                }
            });
        });
    });
</script>
<input id="inputfile" type="file"/>
