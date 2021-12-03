package ru.vsu.sc.uliyanov_n_s.error;
// Не знаю насколько корректно я сделал вывод ошибки

import ru.vsu.sc.uliyanov_n_s.utils.SwingUtils;

public class ErrorMessage {
    public static void printErrorMessage(int codeOfError) {
        String errorMessage = null;

        switch (codeOfError) {
            case 0:
                errorMessage = "Не удалось считать массив!";
                break;
            case 1:
                errorMessage = "Не удаётся загрузить файл!";
                break;
            case 2:
                errorMessage = "Не удаётся сохранить файл!";
                break;
            case 3:
                errorMessage = "Не удаётся выполнить действие!";
                break;
        }

        SwingUtils.showErrorMessageBox(errorMessage);
    }
}
