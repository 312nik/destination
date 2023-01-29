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