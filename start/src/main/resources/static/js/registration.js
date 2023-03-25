const currentUrl = window.location.pathname;
switch(currentUrl){
    case "/registration/client":
        document.getElementById('block1').style.display = 'block';
        break;
    case "/registration/master":
        document.getElementById('block2').style.display = 'block';
        break;
    }
document.getElementById("priceActivity").textContent = pageName;