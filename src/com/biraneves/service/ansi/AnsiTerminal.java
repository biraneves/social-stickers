package com.biraneves.service.ansi;

/**
 *
 * Constants that change text appearance on terminal. Based on Wikipedia article ANSI escape code.
 *
 * @author biraneves
 *
 */
interface AnsiTerminal {

    // Color reset
    String RESET = "\u001b[0m";  // Reset color and effect

    // Normal
    String BLACK = "\u001b[0;30m";
    String RED = "\u001b[0;31m";
    String GREEN = "\u001b[0;32m";
    String YELLOW = "\u001b[0;33m";
    String BLUE = "\u001b[0;34m";
    String MAGENTA = "\u001b[0;35m";
    String CYAN = "\u001b[0;36m";
    String WHITE = "\u001b[0;37m";
    String DEFAULT = "\u001b[0;39m";    // Reset color only

    // Bold
    String BLACK_BOLD = "\u001b[1;30m";
    String RED_BOLD = "\u001b[1;31m";
    String GREEN_BOLD = "\u001b[1;32m";
    String YELLOW_BOLD = "\u001b[1;33m";
    String BLUE_BOLD = "\u001b[1;34m";
    String MAGENTA_BOLD = "\u001b[1;35m";
    String CYAN_BOLD = "\u001b[1;36m";
    String WHITE_BOLD = "\u001b[1;37m";
    String DEFAULT_BOLD = "\u001b[1;39m";

    // Faint
    String BLACK_FAINT = "\u001b[2;30m";
    String RED_FAINT = "\u001b[2;31m";
    String GREEN_FAINT = "\u001b[2;32m";
    String YELLOW_FAINT = "\u001b[2;33m";
    String BLUE_FAINT = "\u001b[2;34m";
    String MAGENTA_FAINT = "\u001b[2;35m";
    String CYAN_FAINT = "\u001b[2;36m";
    String WHITE_FAINT = "\u001b[2;37m";
    String DEFAULT_FAINT = "\u001b[2;39m";

    // Italic
    String BLACK_ITALIC = "\u001b[3;30m";
    String RED_ITALIC = "\u001b[3;31m";
    String GREEN_ITALIC = "\u001b[3;32m";
    String YELLOW_ITALIC = "\u001b[3;33m";
    String BLUE_ITALIC = "\u001b[3;34m";
    String MAGENTA_ITALIC = "\u001b[3;35m";
    String CYAN_ITALIC = "\u001b[3;36m";
    String WHITE_ITALIC = "\u001b[3;37m";
    String DEFAULT_ITALIC = "\u001b[3;39m";

    // Underline
    String BLACK_UNDERLINE = "\u001b[4;30m";
    String RED_UNDERLINE = "\u001b[4;31m";
    String GREEN_UNDERLINE = "\u001b[4;32m";
    String YELLOW_UNDERLINE = "\u001b[4;33m";
    String BLUE_UNDERLINE = "\u001b[4;34m";
    String MAGENTA_UNDERLINE = "\u001b[4;35m";
    String CYAN_UNDERLINE = "\u001b[4;36m";
    String WHITE_UNDERLINE = "\u001b[4;37m";
    String DEFAULT_UNDERLINE = "\u001b[4;39m";

    // Bright
    String BLACK_BRIGHT = "\u001b[0;90m";
    String RED_BRIGHT = "\u001b[0;91m";
    String GREEN_BRIGHT = "\u001b[0;92m";
    String YELLOW_BRIGHT = "\u001b[0;93m";
    String BLUE_BRIGHT = "\u001b[0;94m";
    String MAGENTA_BRIGHT = "\u001b[0;95m";
    String CYAN_BRIGHT = "\u001b[0;96m";
    String WHITE_BRIGHT = "\u001b[0;97m";
    String DEFAULT_BRIGHT = "\u001b[0;99m";

    // Bold and bright
    String BLACK_BOLD_BRIGHT = "\u001b[1;90m";
    String RED_BOLD_BRIGHT = "\u001b[1;91m";
    String GREEN_BOLD_BRIGHT = "\u001b[1;92m";
    String YELLOW_BOLD_BRIGHT = "\u001b[1;93m";
    String BLUE_BOLD_BRIGHT = "\u001b[1;94m";
    String MAGENTA_BOLD_BRIGHT = "\u001b[1;95m";
    String CYAN_BOLD_BRIGHT = "\u001b[1;96m";
    String WHITE_BOLD_BRIGHT = "\u001b[1;97m";
    String DEFAULT_BOLD_BRIGHT = "\u001b[1;99m";

    // Background color
    String WHITE_ON_BLACK = "\u001b[0;97;100m";
    String WHITE_ON_RED = "\u001b[0;97;101m";
    String WHITE_ON_GREEN = "\u001b[0;97;102m";
    String WHITE_ON_YELLOW = "\u001b[0;97;103m";
    String WHITE_ON_BLUE = "\u001b[0;97;104m";
    String WHITE_ON_MAGENTA = "\u001b[0;97;105m";
    String WHITE_ON_CYAN = "\u001b[0;97;106m";
    String WHITE_ON_WHITE = "\u001b[0;97;107m";
    String WHITE_ON_DEFAULT = "\u001b[0;97;109m";

}
