$(document).ready(function () {
    $.ajax({
        url: '/data/customerData.json',
        type: 'GET',
        success: function (data) {
            data.forEach(function (account) {
                $('#listAccounts').append('<li class="list-group-item">' + account.accountNumber + " | " + account.customerName + ' | ' + account.accountType + '</li>');
            });
            localStorage.setItem("accounts", JSON.stringify(data));
        },
        error: function (e) {
            console.log(e.message);
            if (localStorage.getItem("accounts") !== undefined) {
                JSON.parse(localStorage.getItem("accounts")).forEach(function (account) {
                    $('#listAccounts').append('<li class="list-group-item">' + account.accountNumber + " | " + account.customerName + ' | ' + account.accountType + '</li>');
                });
            }
        }
    });

    $('#btnSubmit').on('click', function (event) {
        let accountNumber = $('#accountNumber');
        let customerName = $('#customerName');
        let accountType = $('#accountType option:selected');
        if (!accountNumber.val().match(/0\d{1}-\d{3}-\d{4}/g)) {
            return;
        }
        if (accountNumber.val() != "" && customerName.val() != "" && accountType.val() != "") {
            $('#listAccounts').append('<li class="list-group-item">' + accountNumber.val() + " | " + customerName.val() + ' | ' + accountType.val() + '</li>');

            accountNumber.val("");
            customerName.val("");
            $("#accountType option:first").attr('selected', true);
            accountNumber.focus();
            event.preventDefault();
        }
    });
});