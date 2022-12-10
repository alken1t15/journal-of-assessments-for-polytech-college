let calcBtn = document.querySelector(".calc");
calcBtn.addEventListener('click', function(e) {


    let field1 = document.querySelector(".input-field-1");
    let field2 = document.querySelector(".input-field-2");
    let except = document.querySelector(".red-h");
    let res = document.querySelector(".result");
    res.innerHTML = "";

    if(field1.value === "" || field2.value === ""){
        except.classList.add("red-a");
        except.innerHTML = "Вы не заполнили поля";
    }

    else{
        except.classList.remove("red-a");
        except.innerHTML = "";
        let f1 = Number(field1.value);
        let f2 = Number(field2.value);
        if(!Number.isInteger(f1) || !Number.isInteger(f2)){
            except.classList.add("red-a");
            except.innerHTML = "Заполните поля от 1 до 100";
        }
        else if((f1 >100 || f1<1) || (f2 >100 || f2<1)){
            except.classList.add("red-a");
            except.innerHTML = "Заполните поля от 1 до 100";
        }
        else{
            except.classList.remove("red-a");
            except.innerHTML = "";
            res.classList.add("result-active");
            //res.textContent = toString(f1 * 0.6 + f2 * 0.4);
            res.innerHTML = f1 * 0.6 + f2 * 0.4;
            e.preventDefault();
        }
    }
});