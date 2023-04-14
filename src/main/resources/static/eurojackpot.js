async function newNumbers() {
    const number_list = [];
    for (let i = 1; i <= 6; i++) {
        const number = document.getElementById(i).value;
        if (number !== '') {
            number_list.push(number)
        }
    }
    const heading = document.getElementById('numbers');
    const response = await fetch('/api/v1/eurojackpot?bn=' + number_list.join(','));
    const json = await response.json();
    console.log(json)
    heading.innerHTML = json.slice(0, 5).join(' ') + '<span class="gold">' + json.slice(5, 7).join(' ') + '</span>';
}
newNumbers();

const submit = document.getElementById('generate');
submit.addEventListener('click', event => {
    event.preventDefault();
    newNumbers();
});
