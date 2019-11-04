"use strict";
$(document).ready(() => {
    $('#exampleModal').on('show.bs.modal', (e) => {
        let line1 = "Product number : <b>" + $("#productForm #pnumber").val() + "</b>";
        let line2 = "Quantity In Stock : <b>" + $("#productForm #qinstock").val() + "</b>";
        let line3 = "Name : <b>" + $("#productForm #name").val() + "</b>";
        let line4 = "Supplier : <b>" + $("#productForm .custom-select").val() + "</b>";
        let line5 = "Unit Price : <b>" + $("#productForm #unitPrice").val() + "</b>";
        let line6 = "Date : <b>" + $("#productForm #datee").val() + "</b>";

        $('.modal-body').html(
            '<div>' + line1 + '</div>' +
            '<div>' + line2 + '</div>' +
            '<div>' + line3 + '</div>' +
            '<div>' + line4 + '</div>' +
            '<div>' + line5 + '</div>' +
            '<div>' + line6 + '</div>'
        );
    });
});