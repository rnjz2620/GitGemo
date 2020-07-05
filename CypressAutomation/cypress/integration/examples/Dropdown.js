///<reference types="Cypress"/>

describe('My First Test Suite',function()
{

it('My firstTest case',function() {

cy.visit("https://rahulshettyacademy.com/AutomationPractice/")

//Static Dropdown (Fixed Dropdown)
cy.get('select').select('option2').should('have.value','option2')

//Dynamic Dropdown (AutoComplete)
cy.get('#autocomplete').type('ban')

cy.get('.ui-menu-item div').each(($el, index, $list) => 
{
    if($el.text()==='Bangladesh')
    {
        $el.click()
    }
})
cy.get('#autocomplete').should('have.value', 'Bangladesh')

})


})