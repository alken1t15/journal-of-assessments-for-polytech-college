const tabs = document.querySelectorAll(".tabs__item");
const tabsItems = document.querySelectorAll(".tabs-content");

tabs.forEach(function(e){
    e.addEventListener('click', function(){
        let currentBtn = e;
        let tabId = currentBtn.getAttribute('data-tab');
        let currentTab = document.querySelector(tabId);

        if(!currentBtn.classList.contains('is-active')){
            tabs.forEach(function(item){
                item.classList.remove('is-active');
            });
    
            tabsItems.forEach(function(item){
                item.classList.remove('tab-is-active');
            });
    
            currentBtn.classList.add("is-active");
            currentTab.classList.add('tab-is-active');
        }

     
    });
});