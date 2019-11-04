"use strict";

window.onload = () => {
    document.getElementById("submitButton").onclick = () => {
        if (document.forms[0].email.value == "") {
            alert("fill email");
        } else {
            console.log(document.forms[0].email.value);
        }
        if (document.forms[0].password.value == "") {
            alert("fill password");
        } else {
            console.log(document.forms[0].password.value);
        }
        if (document.forms[0].url.value == "") {
            alert("fill url");
        } else {
            console.log(document.forms[0].url.value);
        }
    }
}