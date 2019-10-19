$(function(){

    var $selectedComment = null;


    var loadWeatherData = function(city){
        var apiKey = "cfed679d59a400ce311452d1f70e6c4d";
        $.ajax({
            method: "GET",
            url: "http://api.openweathermap.org/data/2.5/weather",
            data: {
                q: city,
                appid: apiKey,
                units: "metric"
            }
        })
        .done(function( response ) {
            $('#current-temp').text(response.main.temp);
        });
    }

    var loadInitialData = function(){
        var city = $('#select-city').val();
        loadWeatherData(city);
    }

    $("#publish").on("click", function(){

        var city = $('#select-city').val();
        var cityLabel = $("#select-city option:selected").text();
        var $comment = $('#comment');
        var comment = $comment.val();
        var temperature = $("#current-temp").text();

        publishComment(cityLabel, comment, temperature);
        $comment.val('');
    })

    var publishComment = function(cityLabel, comment, temperature){

        var $template = $('#comment-template').html();
        $template = $($template);

        $template.find('span').text(temperature);
        $template.find('h4').text(cityLabel);
        $template.find('p').text(comment);
        
        var $commentsList = $("#comments-list");
        $commentsList.append($template);

    }


    $("#select-city").on("change", function(){
       var selectedCity = $(this).val();
       loadWeatherData(selectedCity);
    })

    $(document).on('click', '.remove-item', function() {
        $selectedComment = $(this).closest('.list-group-item');
    })

    $("#confirm-delete").on("click", function(){
        $selectedComment.remove();
        $('#confirmDeleteModal').modal('hide');
    })

    loadInitialData();

})