let btnNew = document.getElementById('btnAdd');

btnNew.onclick = function(){
    let inputText = document.getElementById('inputText');
    let itemText = inputText.value;
    
    if(!itemText || itemText === "" || itemText === " ") return false;
    addNewItem(document.getElementById('todolist'), itemText);
}

function addNewItem(list, itemText){    
    let listItem = document.createElement('li');
    listItem.innerText = itemText;
    list.appendChild(listItem);
}

