
$(async function() {
    await allUsers();
});


async function allUsers() {
    $.ajax({
        url: '/api/users',
        method: 'get',
        dataType: 'json',
        success: function (data) {
            createTable(data)
        }
    });
}



function createTable(data)  {
    const tableBody = document.getElementById('tbodyAllUser');
    let dataHtml = '';

    for (let user of data) {

        dataHtml += `<tr>
           <td>${user.id}</td>
           <td>${user.name}</td>
           <td>${user.lastName}</td>
           <td>${user.age}</td>
           <td>${user.email}</td>
           <td>${user.roleToString}</td>
          <td>
            <button type="button" class="btn btn-info text-white" data-bs-toggle="modal" id="buttonEdit"
             data-bs-target="#editModal" onclick=getEditModal(${user.id})> Edit </button>
          </td>
          <td>
             <button type="button" class="btn btn-danger text-white" data-bs-toggle="modal" id="buttonDelete"
             data-bs-target="#deleteModal" onclick="getDeleteModal(${user.id})" >Delete</button>
          </td>
            </tr>`
    }
    tableBody.innerHTML = dataHtml;
}
