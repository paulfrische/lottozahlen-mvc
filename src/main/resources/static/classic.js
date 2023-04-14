async function newNumbers() {
    const number_list = [];
    for (let i = 1; i <= 6; i++) {
        const number = document.getElementById(i).value;
        if (number !== '') {
            number_list.push(number)
        }
    }
    const heading = document.getElementById('numbers');
    const response = await fetch('/api/v1/classic?bn=' + number_list.join(','));
    const json = await response.json();
    json.sort((a, b) => a - b)
    heading.innerHTML = json.join(' ');
}
newNumbers();

const submit = document.getElementById('generate');
submit.addEventListener('click', event => {
    event.preventDefault();
    newNumbers();
});
