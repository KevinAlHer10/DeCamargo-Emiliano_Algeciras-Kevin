window.addEventListener('load', function () {

    const formulario = document.querySelector('#add_new_paciente');

    formulario.addEventListener('submit', function (event) {

        const formData = {
            identificationNumber: document.querySelector('#identificationNumber').value,
            name: document.querySelector('#name').value,
            lastname: document.querySelector('#lastname').value,
            date: document.querySelector('#date').value,
            address: document.querySelector('#address').value,
            email: document.querySelector('#email').value,

        };
        const url = '/patients';
        const settings = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }

        fetch(url, settings)
            .then(response => response.json())
            .then(data => {
                 let successAlert = '<div class="alert alert-success alert-dismissible">' +
                     '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                     '<strong></strong> Patient add </div>'

                 document.querySelector('#response').innerHTML = successAlert;
                 document.querySelector('#response').style.display = "block";
                 resetUploadForm();

            })
            .catch(error => {
                    let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                                     '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                                     '<strong> Error. Please try again</strong> </div>'

                      document.querySelector('#response').innerHTML = errorAlert;
                      document.querySelector('#response').style.display = "block";
                     resetUploadForm();})
    });


    function resetUploadForm(){
        document.querySelector('#identificationNumber').value = "";
        document.querySelector('#name').value = "";
        document.querySelector('#lastname').value = "";
        document.querySelector('#date').value = "";
        document.querySelector('#address').value = "";
        document.querySelector('#email').value = "";

    }

    (function(){
        let pathname = window.location.pathname;
        if(pathname === "/"){
            document.querySelector(".nav .nav-item a:first").addClass("active");
        } else if (pathname == "/get_dentists.html") {
            document.querySelector(".nav .nav-item a:last").addClass("active");
        }
    })();
});