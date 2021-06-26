function menuAction() {
    // Выбираем раздел меню
    let menuSection = document.querySelector(".menu");
    // Берем кнопки
    let buttons = menuSection.querySelectorAll(".customer_menu-button");

    // Кнопка "Обо мне"
    buttons[0].addEventListener("click", () => {
        if (buttons[0].classList.contains("selected_button")) return;
        // Делать что-то
    })
    // Кнопка "Методика"
    buttons[1].addEventListener("click", () => {
        if (buttons[1].classList.contains("selected_button")) return;
        // Делать что-то
    })
    // Кнопка "Запись"
    buttons[2].addEventListener("click", () => {
        if (buttons[2].classList.contains("selected_button")) return;
        // Делать что-то
    })
    // Кнопка "Связь"
    buttons[3].addEventListener("click", () => {
        if (buttons[3].classList.contains("selected_button")) return;
        document.querySelector(".footer").scrollIntoView(false);
    })
}

function selector() {
    let buttons = [];
    let tabs = [];
    for (let i = 0; i <= 40; i++) {
        let button = document.querySelector("#data_button_" + i);
        if (button == null) break;
        button.addEventListener("click", () => {
            let tabs = document.querySelectorAll(".time_section");
            tabs.forEach(tab => disable(tab));
            let tab = document.querySelector("#time_section_" + i);
            if (tab.classList.contains("disabled_section")) {
                tab.classList.remove("disabled_section");
            }
        })
    }

    function disable(tab) {
        if (!tab.classList.contains("disabled_section")) {
            tab.classList.add("disabled_section");
        }
    }
}

window.onload = () => {
    menuAction();
    selector();
}