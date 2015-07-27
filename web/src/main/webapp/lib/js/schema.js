$(function() {
    $('#updateSchema').hide();
    $('.delete_button').on('click', function () {
        if(confirm("确定要删除吗？")){
            var id = $(this).attr('id');
            $.ajax({
                url: '/web/schema/deleteSchema/' + id,
                type: 'DELETE',
                dataType: 'text',
                success: function () {
                    //this.closest("delete_button")remove();
                    window.location.reload();
                }
            })
        }

    });

    $('.update_button').on('click', function () {
        $('#updateSchema').show();
        var id = $(this).attr('id');
        $.ajax({
            contentType: 'application/json; charset=utf-8',
            url: '/web/schema/updateSchema/' + id,
            type: 'GET',
            dataType: 'json',
            success: function (data) {
                console.log(data);
                $('#course').text(data.course.name);
                $("#employee").text(data.employee.name);
                $("#time").text(data.time);
                $("#customer").text(data.customer);
                $("#id").val(data.id);
            }
        });
    });

    $('#confirmUpdate_button').on('click', function () {
        var dataString = $("#updateSchema").serialize();
        var id = $('#id').val();
          $.ajax({
                url: '/web/schema/updateSchema/' + id,
                type: 'PUT',
                dataType: 'text',
                data: dataString,
                success: function () {
                    window.location= '/web/schema/';
                }
            });

    });



});


