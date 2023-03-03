import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CidadeListagemComponent } from './cidade-listagem.component';

describe('CidadeListagemComponent', () => {
  let component: CidadeListagemComponent;
  let fixture: ComponentFixture<CidadeListagemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CidadeListagemComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CidadeListagemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
