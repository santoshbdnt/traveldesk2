function ShowHideDiv() {
    var ddlPassport = document.getElementById("ddlPassport");
    var dvPassport = document.getElementById("dvPassport");
    var dvPassport1 = document.getElementById("dvPassport1");
    var dvPassport2 = document.getElementById("dvPassport2");
    var dvPassport3 = document.getElementById("dvPassport3");
    
    
    dvPassport.style.display = ddlPassport.value === "Date" ? "block" : "none";
    dvPassport1.style.display = ddlPassport.value === "Full name" ? "block" : "none"
    dvPassport2.style.display = ddlPassport.value === "IN Id" ? "block" : "none"
	dvPassport3.style.display = ddlPassport.value === "spoke" ? "block" : "none"
} 