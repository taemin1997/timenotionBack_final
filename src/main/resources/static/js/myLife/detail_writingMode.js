document.getElementById('file').addEventListener('change', function(event) {
    const fileInput = event.target;
    const fileNamesDiv = document.getElementById('file-names');
    fileNamesDiv.innerHTML = '';

    const files = fileInput.files;
    if (files.length > 0) {
        const fileList = document.createElement('ul');
        for (let i = 0; i < files.length; i++) {
            const listItem = document.createElement('li');
            listItem.textContent = files[i].name;
            fileList.appendChild(listItem);
        }
        fileNamesDiv.appendChild(fileList);
    } else {
        fileNamesDiv.textContent = '';
    }
});

//공개 비공개
function toggleVisibility() {
    var selectElement = document.getElementById("select-visibility-detail");
    var contentElement = document.getElementById("content-to-toggle");

    if (selectElement.value === "O") {
        contentElement.style.display = "block";
    } else {
        contentElement.style.display = "none";
    }
}