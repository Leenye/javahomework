$(function() {
    var course;
    $('#updateSchema').hide();
    $('.delete_button').on('click', function () {
        course = this;
        if(confirm("确定要删除吗？")){
            var id = $(this).attr('id');
            $.ajax({
                url: '/web/schema/deleteSchema/' + id,
                type: 'DELETE',
                dataType: 'text',
                success: function (data) {
                    alert(this);
                    alert(data);
                    course.closest('tr').remove();
                }
            })
        }
    });

    $('.update_button').on('click', function () {
        $('#updateSchema').show();
        var id = $(this).attr('id');
        $.ajax({
            contentType: 'application/json; charset=utf-8',
            url: '/web/schema/updateSchema/'+id,
            type: 'GET',
            dataType: 'json',
            success: function (data) {
                $('#course').text(data.course.name);
                $("#employee").text(data.employee.name);
                $("#time").text(data.time);
                $("#customer").text(data.customer);
                $("#id").val(data.id);
            }
        });
    });

    $('#confirmUpdate_button').on('click', function (e) {
        var id = $('#id').val();
        alert('id');

        var dataString = $("#updateSchema").serialize();
        //alert(id);
        $.ajax({
            url: '/web/schema/updateSchema/'+id,
            type: 'POST',
            data: dataString,
            dataType: 'text',
            success: function () {
                alert("修改成功");
                window.location = 'http://localhost:8080/web/schema';
            },
            error: function () {
                alert(" 课程已存在，请输入其他课程");
                return;
            }

        });
    });
});


