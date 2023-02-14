

const formEdit = document.getElementById('formEditing');
const idEdit=document.getElementById('idEdit');
const firstnameEdit=document.getElementById('nameEdit');
const lastnameEdit=document.getElementById('lastnameEdit');
const ageEdit=document.getElementById('ageEdit');
const emailEdit=document.getElementById('emailEdit');
const passwordEdit=document.getElementById('passwordEdit');

async function getEditModal(id) {

    const urlEdit= '/api/users/' + id;

    $.ajax({
        url: urlEdit,
        method: 'get',
        dataType: 'json',
        success: function (data) {

            idEdit.value = data.id;
            firstnameEdit.value = data.name;
            lastnameEdit.value = data.lastName;
            ageEdit.value = data.age;
            emailEdit.value = data.email;
            passwordEdit.value = data.password;

        },
        error: function (jqXHR, exception){
            alert('Uncaught Error. ' + jqXHR.responseText);
        }


    })
}




async function editUser() {

        let urlEdit = '/api/users/' + idEdit.value;

        const selected = Array.from(rolesEdit.options)
            .filter(option => option.selected)
            .map(option => option.value.toString());


        const dataEdit = {
            id:formEdit.idEdit.value,
            name: formEdit.nameEdit.value.trim(),
            lastName: formEdit.lastnameEdit.value.trim(),
            age: formEdit.ageEdit.value,
            email: formEdit.emailEdit.value.trim(),
            password: formEdit.passwordEdit.value.trim(),
            roles: selected
        }

        function updateUser() {
            return $.ajax({
                type: 'PATCH',
                headers: {'Content-Type': 'application/json'},
                url: urlEdit,
                data: JSON.stringify(dataEdit)
            });
        }


        /*$.when(updateUser())
            .then(() => {
                alert("1");
                allUsers();
                alert("2");
                var someTabTriggerEl = document.querySelector('#nav-user-table-tab');
                var tab = new bootstrap.Tab(someTabTriggerEl);
                tab.show();
                $('#closeEdit').click();
            })*/

}






