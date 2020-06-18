function getGithubInfo(user) {
    //Create an instance of XMLHttpRequest class and send a GET request using it.
    var username='https://api.github.com/users/'+user;
    console.log(username);
    $.ajax({
        type: "GET",
        url: username,
        dataType: 'json',

    }).done(function(data){
        showUser(data);

    }).fail(function(){
        console.log("Some error Happened");
        noSuchUser(user);
    });

}
function showUser(user) {
    //set the contents of the h2 and the two div elements in the div '#profile' with the user content
    document.getElementById('imgavg').src=user.avatar_url;
    document.getElementById('txtname').innerText=user.name;
    document.getElementById('txtid').innerText=user.id;
    document.getElementById('txturl').href=user.url;
    document.getElementById('txturl').innerText=user.html_url;
    document.getElementById('txtrepository').innerText=user.public_repos;
    document.getElementById('followers').innerText=user.followers;
    document.getElementById('following').innerText=user.following;
}
function noSuchUser(username) {
    //set the elements such that a suitable message is displayed
    if(data.message == "Not Found" || username == '') {
        alert("User not found");
    }
}
$(document).ready(function () {
    $(document).on('keypress', '#username', function (e) {
        if (e.which == 13) {
            username = $(this).val();
            //change the text typed
            $(this).val("");
            //get the user's information and store the respsonse
            getGithubInfo(username);
            //if the response is successful show the user's details

        }
    })
});