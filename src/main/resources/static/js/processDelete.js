function processDelete() {
    var id = $('.table-success')[0].dataset.id;
    window.location.replace(window.location.href + '/delete/' + id);
}