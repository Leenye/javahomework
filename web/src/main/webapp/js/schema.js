$(function() {
    $('#updateSchema').hide();

    $('.delete_button').on('click', function (e) {
        e.preventDefault();
        var currentRow = $(this).closest('tr');
        if(confirm("确定要删除吗？")){
            var id = $(this).attr('id');
            $.ajax({
                url: '/web/schema/deleteSchema/' + id,
                type: 'DELETE',
                dataType: 'text',
                success: function () {
                    currentRow.remove();
                }
            })
        }
    });

    var updateButton;
    var currentRow;

    $('.update_button').on('click', function (e) {
        e.preventDefault();

        updateButton = $(this).attr('id');
        currentRow = $(this).closest('tr');
        $('#updateSchema').show();

        $('#confirmUpdate_button').on('click', function(e) {
                e.preventDefault();

                $('#id').val(updateButton);
                console.log(updateButton+"___________");
                var dataString = $("#updateSchema").serialize();
                $.ajax({
                    url: '/web/schema/updateSchema',
                    type: 'POST',
                    data: dataString,
                    dataType: 'json',
                    success: function (data) {
                        $('#courseName').text(data.course.name);
                        $("#coachName").text(data.employee.name);
                        $("#courseTime").text(data.time);
                        $("#courseCustomer").text(data.customer);
                        $('#updateSchema').hide();
                    }
                });
            }

        );

    });

});


