$('#table').on('click', '.clickable-row', function (event) {
    $(this).addClass('table-success').siblings().removeClass('table-success');

    $('#initUpdateRow').removeClass('disabled');
    $('#initDeleteRow').removeClass('disabled');
})