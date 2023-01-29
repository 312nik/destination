/*const url_new = '/rest/admin/new';
const roles_new = document.querySelector('#roles').selectedOptions;
const form_new = document.forms["formForCreatingNewUser"];

async function newUser() {
    form_new.addEventListener('submit', addNewUser)

    async function addNewUser(e) {
        e.preventDefault();
        let listOfRole = [];
        for (let i = 0; i < roles_new.length; i++) {
            listOfRole.push("ROLE_" + roles_new[i].value);
        }

        let method = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                firstName: form_new.firstName.value,
                lastName: form_new.lastName.value,
                age: form_new.age.value,
                username: form_new.username.value,
                password: form_new.password.value,
                roles: listOfRole
            })
        }

        await fetch(url_new, method).then(() => {
            form_new.reset();
            getAdminGeneralPage();
            $("#tabBtnAllUsers").click();
        });
    }
}*/

/*
const addForm = document.getElementById("newUser");

        document.getElementById("newUser").value = "Please Wait...";

        const data = await fetch("/api/users", {
            method: "POST",
            body: formData,
        });
        const response = await data.text();
        showAlert.innerHTML = response;
        document.getElementById("add-user-btn").value = "Add User";
        addForm.reset();
        addForm.classList.remove("was-validated");
        addModal.hide();
        fetchAllUsers();
    }
});*/
$(async function() {
    await allUsers();
    getPrincipal();
});
/*
principal*/

function getPrincipal() {
    fetch("/api/user")
        .then(res => res.json())
        .then(data => {
            $('#user-email').append(data.email);

            $('#user-roles').append(data.roleToString);
            let user = `$(
                <tr>
                    <td>${data.id}</td>
                    <td>${data.name}</td>
                    <td>${data.lastName}</td>
                    <td>${data.age}</td>   
                    <td>${data.email}</td>
                    <td>${data.roleToString}</td>
                </tr>)`;
            $('#tbody').append(user);
        })
}


/*allUSers*/

const table = $('#tbodyAllUser');

async function allUsers() {
    table.empty()
    fetch("/api/users")
        .then(res => res.json())
        .then(data => {
            data.forEach(user => {
                let allUsers = `$(
                        <tr>
                            <td>${user.id}</td>
                            <td>${user.name}</td>
                            <td>${user.lastName}</td>                                               
                            <td>${user.age}</td>
                            <td>${user.email}</td>
                            <td>${user.roleToString}</td>
                            <td>
                                <button type="button" class="btn btn-info text-white" data-bs-toggle="modal" id="buttonEdit"
                                data-action="edit" data-id="${user.id}" data-target="#editModal">Edit</button>       
                                /*onclick="editModalData(${user.id}*/
                        
                            </td>
                            <td>
                                <button type="button" class="btn btn-danger text-white" data-bs-toggle="modal" id="buttonDelete"
                                data-action="delete" data-id="${user.id}" data-target="#deleteModal">Delete</button>
                               /*onclick="deleteModalData(${user.id}*/
                            </td>
                        </tr>)`;
                table.append(allUsers);
            })
        })
}


async function addNewUser() {
    $('#addNewUser').click(async () =>  {
        let addUserForm = $('#newUser')
        let userName = addUserForm.find('#newUserName').val().trim();

        let data = {
            name: userName
        }

        let method = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                name: addUserForm.find("#newUserName").val().trim(),
               /* lastName: form_new.lastName.value,
                age: form_new.age.value,
                email: form_new.username.value,
                password: form_new.password.value,
                roles: listOfRole*/
            })
        }




        await fetch("/api/users", method).then(() => {
            form_new.reset();
            getAdminGeneralPage();
            $("#tabBtnAllUsers").click();
        });


        allUsers();

        /*if (response.ok) {
            allUsers();

        } else {
            let body = await response.json();
            let alert = `<div class="alert alert-danger alert-dismissible fade show col-12" role="alert" id="sharaBaraMessageError">
                            ${body.info}
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>`;
            addUserForm.prepend(alert)
        }*/
    })}