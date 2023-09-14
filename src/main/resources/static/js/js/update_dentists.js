window.addEventListener('load', function () {

    const formulario = document.querySelector('#update_dentist_form');

    formulario.addEventListener('submit', function (event) {
        let odontologoId = document.querySelector('#dentist_id').value;

        const formData = {
            id: document.querySelector('#dentist_id').value,
            matricula: document.querySelector('#credential').value,
            nombre: document.querySelector('#name').value,
            apellido: document.querySelector('#lastname').value,

        };

        const url = '/dentists';
        const settings = {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }
          fetch(url,settings)
          .then(response => response.json())

    })
 })

    function findBy(id) {
          const url = '/dentists'+"/"+id;
          const settings = {
              method: 'GET'
          }
          fetch(url,settings)
          .then(response => response.json())
          .then(data => {
              let dentist = data;
              document.querySelector('#dentist_id').value = dentist.id;
              document.querySelector('#credential').value = dentist.credential;
              document.querySelector('#name').value = dentist.name;
              document.querySelector('#lastname').value = dentist.lastname;
              document.querySelector('#div_dentist_updating').style.display = "block";
          }).catch(error => {
              alert("Error: " + error);
          })
      }