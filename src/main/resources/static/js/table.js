t.on( 'key', function ( e, datatable, key, cell, originalEvent ) {

    console.log( '<div>Key press: '+key+' for cell <i>'+cell.data()+'</i></div>' );
} )
    .on( 'key-focus', function ( e, datatable, cell ) {$('.focus').focus();range = document.createRange();
        range.selectNodeContents($('.focus')[0]);
        range.collapse(false);sel = window.getSelection();
        sel.removeAllRanges();
        sel.addRange(range);
        console.log( '<div>Cell focus: <i>'+cell.data()+'</i></div>' );
    } )
    .on( 'key-blur', function ( e, datatable, cell ) {
        cell.data($(cell.node()).text())
        console.log( '<div>Cell blur: <i>'+cell.data()+'</i></div>' );
    } )