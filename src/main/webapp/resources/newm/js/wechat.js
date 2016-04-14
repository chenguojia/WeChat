// Initialize your app
var myApp = new Framework7({
    modalTitle: '卡得万利商业保理',
    ajaxLinks: 'a.ajax'
});

// Add view
var mainView = myApp.addView('.view-main', {
    // Because we use fixed-through navbar we can enable dynamic navbar
    dynamicNavbar: true
});

// Callbacks to run specific code for specific pages, for example for About page:
myApp.onPageInit('about', function (page) {
    // run createContentPage func after link was clicked
    $$('.create-page').on('click', function () {
        createContentPage();
    });
});

function popClose(){
    $('.close-display').removeClass('display-none')
}

