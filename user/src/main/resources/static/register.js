
$(document).ready(function () {

    $("#search-form").submit(function (event) {
        //stop submit the form, we will post it manually.
        event.preventDefault();
        fire_ajax_submit();
    });

});

function fire_ajax_submit() {	
    var search = {}
    search["name"] = $("#name").val();
	search["surname"] = $("#surname").val();
	search["mdp"] = $("#mdp").val();
	search["re-password"] = $("#re-password").val();

    $("#sign").prop("disabled", true);

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/newuser",
        data: JSON.stringify(search),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
            var json = "<h4>Ajax Response</h4>&lt;pre&gt;"
                + JSON.stringify(data, null, 4) + "&lt;/pre&gt;";
            $('#feedback').html(json);

            console.log("SUCCESS : ", data);
            $("#sign").prop("disabled", false);

        },
        error: function (e) {

            var json = "<h4>Ajax Response</h4>&lt;pre&gt;"
                + e.responseText + "&lt;/pre&gt;";
            $('#feedback').html(json);

            console.log("ERROR : ", e);
            $("#sign").prop("disabled", false);

        }
    });

}