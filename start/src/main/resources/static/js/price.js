const currentUrl = window.location.pathname;
switch(currentUrl){
    case "/services/price-electrician":
        pageName = "Прайс на электромонтажные работы";
        break;
    case "/services/price-finishing":
        pageName = "Прайс на отделочные работы";
        break;
    case "/services/price-plumbing":
        pageName = "Прайс на сантехнические работы";
        break;
    case "/services/price-air-conditioners":
        pageName = "Прайс на установку кондиционеров";
        break;
    case "/services/price-design":
        pageName = "Прайс на проектирование";
        break;
    }
document.getElementById("priceActivity").textContent = pageName;