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
    const normalNumbers = json.slice(0, 5);
    const superNumbers = json.slice(5, 7);
    normalNumbers.sort((a, b) => a - b);
    superNumbers.sort((a, b) => a - b);
    heading.innerHTML = normalNumbers.join(' ') + '<span class="gold">' + superNumbers.join(' ') + '</span>';
}
newNumbers();

const submit = document.getElementById('generate');
submit.addEventListener('click', event => {
    event.preventDefault();
    newNumbers();
});
