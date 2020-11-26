package OmerBey._01_Locators_CssSelector;

public class _01_Bilgi {
// TODO
//          Class aramak için "." kullanıyoruz
//          Tüm html kodlarında class ismi arama--> .btn-default.btn-lg
//          Tüm buttonların içinde class ismini arama --> button.btn-default

//todo          child-parent  span.input-group-btn>button

/*
todo    ID
        button[id=list-view]
        button#list-view
*/

/*
    todo  Contains   * işareti ile bulunur.

    button[onclick*=cart]
*/

/*
    todo Starts with -- >    Başlangıçtaki karakter ile bulma  ^ ile buluruz.    ^=
    html kodu : wishlist.add('40');

    button[onclick^='w']
*/

/*TODO
     nth of type
     ilkii bulmak için:     class ismi button-group olan div in içerisindeki,
     1. buttonu ver  -------     div.button-group>button:first-of-type
     sonuncuyu bulmak için:      div.button-group>button:last-of-type
     ortadakini veya herhngi bir tanesini bulmak için : div.button-group>button:nth-of-type(2)


     google arama kısmı için

     ul.erkvQe>li:nth-of-type(2)
*/




}
