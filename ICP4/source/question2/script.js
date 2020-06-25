function getGithubInformation(user) {
    //Create an instance of XMLHttpRequest class and send a GET request using it.
    var username='https://api.github.com/users/'+user;
    console.log(username);
    $.ajax({
        type: "GET",
        url: username,
        dataType: 'json',

    }).done(function(data){
        showUserData(data);
        
    });

}
function showUserData(user) {
    //set the contents of the h2 and the two div elements in the div '#profile' with the user content
    document.getElementById('imgavg').src=user.avatar_url;
    document.getElementById('txtname').innerText=user.name;
    document.getElementById('txtid').innerText=user.id;
    document.getElementById('txturl').href=user.url;
    document.getElementById('txturl').innerText=user.html_url;
    document.getElementById('txtrepository').innerText=user.public_repos;
    document.getElementById('followers').innerText=user.followers;
    document.getElementById('following').innerText=user.following;
    document.getElementById('company').innerText=user.company;
    document.getElementById('location').innerText=user.location;

}
$(document).ready(function () {
    $(document).on('keypress', '#username', function (e) {
        if (e.which == 13) {
            username = $(this).val();
            $(this).val("");
            getGithubInformation(username);
        }
    })
});