function filterTable(tableName) {
    console.log(tableName);
    var inputText = $('#tableSearch')[0].value.toLowerCase();

    for(i=1; i<$('tr').length; i++) {
        var tdOne, tdTwo, needToHide;
        tdOne = $('tr')[i].children[0];
        if(tableName == 'orders') tdTwo = $('tr')[i].children[1];
        else tdTwo = null;
        needToHide = false;
        if(tdOne) {
            var textFromTd = tdOne.textContent;
            if(textFromTd.toLowerCase().indexOf(inputText) == -1) {
                needToHide = true;
            }
        }
        if(tdTwo) {
            var textFromTd = tdTwo.textContent;
            if((textFromTd.toLowerCase().indexOf(inputText) > -1)&&(needToHide)) {
                needToHide = false;
            }
        }
        if(needToHide) $('tr')[i].style.display = "none";
        else $('tr')[i].style.display = "";
    }
}