/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./src/**/*.{html,ts}", "./node_modules/flowbite/**/*.js"],
  theme: {
    extend: {},
    colors: {
      primary: {
        default: "var(--ion-color-primary)",
        shade: "var(--ion-color-primary-shade)",
        tint: "var(--ion-color-primary-tint)",
      },
      vividPink: {
        default: "var(--ion-color-vividPink)",
        shade: "var(--ion-color-vividPink-shade)",
        tint: "var(--ion-color-vividPink-tint)",
      },
      vividOrange: {
        default: "var(--ion-color-vividOrange)",
        shade: "var(--ion-color-vividOrange-shade)",
        tint: "var(--ion-color-vividOrange-tint)",
      },
      simplewhite: {
        default: "var(--ion-color-simplewhite)",
        shade: "var(--ion-color-simplewhite-shade)",
        tint: "var(--ion-color-simplewhite-tint)",
      },
      lightcream: {
        default: "var(--ion-color-lightcream)",
        shade: "var(--ion-color-lightcream-shade)",
        tint: "var(--ion-color-lightcream-tint)",
      },
      lightgreen: {
        default: "var(--ion-color-lightgreen)",
        shade: "var(--ion-color-lightgreen-shade)",
        tint: "var(--ion-color-lightgreen-tint)",
      },
      lightpink: {
        default: "var(--ion-color-lightpink)",
        shade: "var(--ion-color-lightpink-shade)",
        tint: "var(--ion-color-lightpink-tint)",
      },
      dark: {
        default: "var(--ion-color-dark)",
        shade: "var(--ion-color-dark-shade)",
        tint: "var(--ion-color-dark-tint)",
      },
      medium: {
        default: "var(--ion-color-medium)",
        shade: "var(--ion-color-medium-shade)",
        tint: "var(--ion-color-medium-tint)",
      },
    },
    fontFamily: {
      castoro: ["Castoro", "serif"],
      playfairDisplay: ["Playfair-Display", "serif"],
      urbanist: ["Urbanist", "sans-serif"],
      urbanistItalic: ["Urbanist-Italic", "sans-serif"],
      urbanistBold: ["Urbanist-Bold", "sans-serif"],
      urbanistLight: ["Urbanist-Light", "sans-serif"],
      urbanistBlack: ["Urbanist-Black", "sans-serif"],
      urbanistSemiBold: ["Urbanist-SemiBold", "sans-serif"],
      urbanistExtralight: ["Urbanist-Extralight", "sans-serif"],
      urbanistMedium: ["Urbanist-Medium", "sans-serif"],
    },
  },
  plugins: [require("@tailwindcss/typography"), require("flowbite/plugin")],

  corePlugins: {
    preflight: false,
  },
};
