/**
 * 
 */

 	const navOpen_Btn=document.getElementById("nav_btn");
    const navClose_Btn=document.getElementById("nav-close");
    const nav_bar=document.getElementById("nav-background");

    const openModalBtn_mobile = document.getElementById("addEventBtnmob");
    const openModalBtn_desktop = document.getElementById("addEventBtn");
    const closeModalBtn = document.getElementById("closeEventForm");
    const modal = document.getElementById("Modal");

    closeEventForm=()=>{
        modal.style.display = "none";
    }
    closeNavbar=()=>{
        nav_bar.style.display='none'
    }
    openEventForm=()=>{
        modal.style.display = "flex";
    }
    openNavbar=()=>{
        nav_bar.style.display='flex'
    }  