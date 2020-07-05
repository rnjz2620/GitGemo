///<reference types="Cypress"/>

describe('My First Test Suite',function()
{

it('My firstTest case',function() {

cy.visit("https://rahulshettyacademy.com/AutomationPractice/")
//Checkbox and Uncheck with assertion 
cy.get('[type="checkbox"]').check()
cy.get('#checkBoxOption1').uncheck()

cy.get('#checkBoxOption1').check().should('be.checked').and('have.value','option1')
cy.get('#checkBoxOption1').uncheck().should('not.be.checked')

//Multiple checkbox selected

cy.get('[type="checkbox"]').check(['option2','option3'])


})
})