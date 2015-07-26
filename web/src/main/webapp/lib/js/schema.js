$(function() {

    $('#updateSchema').hide();
    $('.delete_button').on('click', function () {
        var id = $(this).attr('id');
        console.log($(this).attr('id'));
        $.ajax({
            url: '/web/schema/deleteSchema/' + id,
            type: 'DELETE',
            dataType: 'text',
            success: function () {
                window.location.reload();
            }
        })
    });

    $('.update_button').on('click', function () {

        $('#updateSchema').show();
        var id = $(this).attr('id');
        $.ajax({
            url: '/web/schema/updateSchema/' + id,
            type: 'PUT',
            dataType: 'text',
            success: function () {
                window.location.reload();
            }
        })
        //var id = $(this).closest('button').attr('id');
        //$.ajax({
        //    url: '/web/schema/updateSchema/' + id,
        //    type: 'PUT',
        //    dataType: 'text',
        //    success: function(){
        //        window.location.reload();
        //        console.log("ok1");
        //    }
        //})
    });
});

//    function confirmDelete() {
//      if (window.confirm("确认要删除本条信息！")) {
//        return true;
//      }
//      return false;
//    }
