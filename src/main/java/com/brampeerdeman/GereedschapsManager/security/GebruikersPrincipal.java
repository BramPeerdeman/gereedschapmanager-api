package com.brampeerdeman.GereedschapsManager.security;

import com.brampeerdeman.GereedschapsManager.model.Gebruiker;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class GebruikersPrincipal implements UserDetails
{

    private Gebruiker gebruiker;

    public GebruikersPrincipal(Gebruiker gebruiker)
    {
        this.gebruiker = gebruiker;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("USER"));
    }

    @Override
    public String getPassword() {
        return gebruiker.getWachtwoord();
    }

    @Override
    public String getUsername() {
        return gebruiker.getGebruikersnaam();
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
