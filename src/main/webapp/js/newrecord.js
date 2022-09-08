function ShowHideDiv() {
    var ddlPassport = document.getElementById("ddlPassport");
    var dvpassport1 = document.getElementById("dvPassportairline");
    var dvpassport10 = document.getElementById("dvPassportflightnumber");
    var dvpassportcode = document.getElementById("dvpassportcode");
    var dvpassportbus = document.getElementById("dvpassportbus");
    var dvPassporttime = document.getElementById("dvPassporttime");

    dvpassport1.style.display = ddlPassport.value === "Flight" ? "block" : "none";
    dvpassportcode.style.display = ddlPassport.value === "Bus" ? "block" : "none";
    dvpassportbus.style.display = ddlPassport.value === "Bus" ? "block" : "none";
    dvpassport10.style.display = ddlPassport.value === "Flight" ? "block" : "none";
    dvPassporttime.style.display = ddlPassport.value === "Flight" ? "block" : "none";
}

function ShowHideDiv1() {
    var ddlPassport7 = document.getElementById("ddlPassport7");
    var dvPassport11 = document.getElementById("dvPassport11");

    var dvPassport13 = document.getElementById("dvPassport13");
    dvPassport11.style.display = ddlPassport7.value === "Yes" ? "block" : "none";

    dvPassport13.style.display = ddlPassport7.value === "Yes" ? "block" : "none";
}