

addNewUser();

function addNewUser() {

    $('#addNewUser').on('click', async function (event) {


        let selected = Array.from(newUserRoles.options)
            .filter(option => option.selected)
            .map(option => option.value.toString());

        let newUser= document.forms['addNewUser'];
        let data = {
            name: newUser.firstname.value.trim,
            lastName: newUser.lastName.value.trim(),
            age: newUser.age.value.trim(),
            email: newUser.email.value.trim(),
            password: newUser.password.value.trim(),
            roles: selected
        }



        $.ajax({
            type: "POST",
            url: '/api/users',
            data: JSON.stringify(data) ,
            success: function(data){
                newUser.reset();
                allUsers();
                $('#v-pills-admin').click();




            },
        });


    })

}