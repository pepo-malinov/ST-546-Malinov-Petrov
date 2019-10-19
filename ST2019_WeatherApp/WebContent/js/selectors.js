// Document ready function
// Гарантира ни, че всички HTML елементи 
// са заредени
$(function() {

// Селектираме по class ".img-fluid"


    $("#login-button").on("click", function(){
        var $inputEmail = $("#email");
        var $inputPassword = $("#password");

        var email = $inputEmail.val();
        var password = $inputPassword.val();


        if(email === "" || password === ""){
            console.log("Enter email and password");
            return;
        }

        var userData = createUserData(email, password);
        console.log(userData);

    })

    var createUserData = function(email, password){
        var userData = {
            email: email,
            password: password
        }
        return userData;
    }

    // Confirm register on click...
    $("#confirm-register").on("click", function(){
        var $registerModal = $("#registerModal");
        var registerEmail = $registerModal.find("#registerEmail").val();
        var registerUsername = $registerModal.find("#registerUsername").val();
        var registerPass = $registerModal.find("#registerPassword").val();
        var registerRepeatPass = $registerModal.find("#repeatPassword").val();


        if(registerEmail.length < 3 || 
            registerUsername.length < 3 || 
            registerPass < 3 ||
            registerRepeatPass < 3
        ) {
            console.log("Minimum characters 3");
            return;    
        }

        if(registerPass !== registerRepeatPass){
             console.log("Password missmatch");   
             return;
        }

        var registerData = createRegisterData(registerEmail, 
            registerUsername, registerPass);

            console.log(registerData);

    })

    var createRegisterData = function(email, username, password){
        var userData = {
            email: email,
            username: username, 
            password: password
        }
        return userData;
    }



});